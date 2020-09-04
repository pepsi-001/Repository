package com.itheima.test;
import com.itheima.domain.UserInfo;
import com.itheima.mapper.UserInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    private UserInfoMapper userMapper;

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
        userMapper = sqlSession.getMapper(UserInfoMapper.class);

        //关闭会话资源
        is.close();
    }


    @Test
    public void testAddUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(0);
        userInfo.setUsername("张三");
        userInfo.setSex("男");
        userInfo.setBirthday(new Date());
        userInfo.setAddress("深圳");
        userMapper.add(userInfo);
    }

    /****
     * 返回一个列表
     */
    @Test
    public void testGetListResultMap(){
        List<UserInfo> users = userMapper.getListResultMap();
        for (UserInfo user : users) {
            System.out.println(user);
        }
    }

    /****
     * 返回一个列表
     */
    @Test
    public void testGetList(){
        List<UserInfo> users = userMapper.getList();
        for (UserInfo user : users) {
            System.out.println(user);
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
