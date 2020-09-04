package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.io.Resources;
import com.itheima.mapper.CatMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.session.SqlSession;
import com.itheima.session.SqlSessionFactory;
import com.itheima.session.SqlSessionFactoryBuilder;
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
         */
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        /****
         * 创建一个会话对象  SqlSession：相当于Connection
         */
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /****
         * 通过会话对象创建UserMapper(Dao接口)的代理对象
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



}
