package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import com.itheima.mapper.AccountMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 15:39
 *
 ****/
public class MyBatisTest {


    private UserMapper userMapper;

    private SqlSession sqlSession;

    private SqlSessionFactory sqlSessionFactory;

    /***
     * 初始化应用
     * @throws Exception
     */
    @Before
    public void init() throws Exception {//读取核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建会话工厂对象的构建对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        /***
         * 会话工厂对象的创建
         * builder.build(is):
         *          构建者模式:隐藏了对象创建的流程，让用户无需关心对象是如何创建的。
         */
        sqlSessionFactory = builder.build(is);

        //SqlSession
        //true:自动提交
        //false:手动提交
        sqlSession = sqlSessionFactory.openSession(true);

        //获取UserMapper接口的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);

        //关闭资源
        is.close();
    }

    /****
     * 一级缓存测试
     */
    @Test
    public void testGetUserOne2MoreCacheSqlSession(){
        //一对多映射关系查询
        /***
         * 延迟加载：
         *     当程序中需要使用到的时候再去查询
         */
        User user = userMapper.getByUserName("王哈哈");
        System.out.println(user.getUsername());

        //执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存
        //sqlSession.clearCache();
        //sqlSession.commit();

        User user1 = userMapper.getByUserName("王哈哈");
        System.out.println(user1.getUsername());

        //另外一个SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);
        User user2 = mapper.getByUserName("王哈哈");
        System.out.println("---"+user2.getUsername());
    }



    /****
     * 二级缓存测试
     */
    @Test
    public void testGetUserOne2MoreSqlSessionFactoryCache() throws InterruptedException {
        //一对多映射关系查询
        /***
         * 延迟加载：
         *     当程序中需要使用到的时候再去查询
         */
        User user = userMapper.getByUserName("王哈哈");
        System.out.println(user.getUsername());

        //执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存
        //sqlSession.clearCache();
        //sqlSession.commit();

/*        User user1 = userMapper.getByUserName("王哈哈");
        System.out.println(user1.getUsername());*/

        sqlSession.commit();


        //另外一个SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);
        User user2 = mapper.getByUserName("王哈哈");
        System.out.println("---"+user2.getUsername());


        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user3 = mapper2.getByUserName("王哈哈");

        Thread.sleep(4000);

        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        User user4 = mapper3.getByUserName("王哈哈");
    }

    /***
     * 关闭资源
     */
    @After
    public void destroy() {
        //提交事物
        //sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }


}
