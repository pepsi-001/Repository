package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.CatMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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

    /***
     * 查询所有测试
     */
    @Test
    public void testFindAll() throws Exception{
        //读取核心配置文件
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
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /****
         * 通过会话对象创建UserMapper(Dao接口)的代理对象
         *              sqlSession.getMapper(UserMapper.class);:代理模式
         *              UserMapper:没有实现类->不能直接执行任何操作
         *                      针对不能直接使用或不能直接和另外其他应用结合使用的对象，我们可以使用代理对象作为一个中间件来实现访问。
         */
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用接口对应的方法实现查询
        List<User> users = userMapper.findAll();

        //输出结果集
        for (User user : users) {
            System.out.println(user);
        }

        //关闭会话资源
        is.close();
        sqlSession.close();
    }


    /***
     * 查询所有测试
     */
    @Test
    public void testFindAllCat() throws Exception{
        //读取核心配置文件
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
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /****
         * 通过会话对象创建UserMapper(Dao接口)的代理对象
         *              sqlSession.getMapper(UserMapper.class);:代理模式
         *              UserMapper:没有实现类->不能直接执行任何操作
         *                      针对不能直接使用或不能直接和另外其他应用结合使用的对象，我们可以使用代理对象作为一个中间件来实现访问。
         */
        CatMapper catMapper = sqlSession.getMapper(CatMapper.class);

        //调用接口对应的方法实现查询
        List<User> users = catMapper.findAll();

        //输出结果集
        for (User user : users) {
            System.out.println(user);
        }

        //关闭会话资源
        is.close();
        sqlSession.close();
    }

}
