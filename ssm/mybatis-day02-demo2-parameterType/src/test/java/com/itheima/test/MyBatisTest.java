package com.itheima.test;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 15:39
 *
 ****/
public class MyBatisTest {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    //创建logger对象，用于记录日志
    Logger logger = Logger.getLogger("MyBatisTest");


    /***
     * 初始化应用
     * @throws Exception
     */
    @Before
    public void init() throws Exception{//读取核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建会话工厂对象的构建对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        /***
         * 会话工厂对象的创建
         * builder.build(is):
         *          构建者模式:隐藏了对象创建的流程，让用户无需关心对象是如何创建的。
         */
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        /****
         * 创建一个会话对象  SqlSession：相当于Connection
         * sqlSessionFactory.openSession():工厂模式
         *              //传统模式new
         *              SqlSession sqlsession = new SqlSessionImpl()
         *
         *              //使用工厂模式解决依赖问题(降低依赖)
         *              SqlSession sqlSession = sqlSessionFactory.openSession();
         */
        sqlSession = sqlSessionFactory.openSession();

        /****
         * 通过会话对象创建UserMapper(Dao接口)的代理对象
         *              sqlSession.getMapper(UserMapper.class);:代理模式
         *              UserMapper:没有实现类->不能直接执行任何操作
         *                      针对不能直接使用或不能直接和另外其他应用结合使用的对象，我们可以使用代理对象作为一个中间件来实现访问。
         */
        userMapper = sqlSession.getMapper(UserMapper.class);

        //关闭会话资源
        is.close();
    }


    /****
     * 根据一个JavaBean中包含另外一个JavaBean的对象去查询数据
     */
    @Test
    public void testQueryVo(){
        QueryVo queryVo = new QueryVo();
        queryVo.setCardNumber("429004100000");
        queryVo.setTelePhone("13670081111");

        //User
        User user = new User();
        user.setUsername("王");
        queryVo.setUser(user);

        //查询用户信息
        List<User> users = userMapper.queryByVo(queryVo);

        for (User u : users) {
            System.out.println(u);
        }

    }








    /***
     * 资源销毁
     */
    @After
    public void destroy(){
        //提交事物
        sqlSession.commit();
        sqlSession.close();
    }

}
