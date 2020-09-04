package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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


    private UserDao userDao;

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

        //创建一个UserDao的实现实例
        userDao = new UserDaoImpl(sqlSessionFactory);
    }


    /****
     * 根据ID查询
     */
    @Test
    public void testGetByUserId(){
        int id=7;
        //根据ID查询
        User user = userDao.getByUserId(id);

        System.out.println(user);
    }


    /***
     * 根据名字模糊查询
     */
    @Test
    public void testGetByUserName(){
        List<User> users = userDao.getByUserName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }


    /***
     * 增加操作
     */
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("小猫");
        user.setAddress("深圳");
        user.setSex("女");
        user.setBirthday(new Date());

        //增加用户
        userDao.addUser(user);

        System.out.println(user);
    }











}
