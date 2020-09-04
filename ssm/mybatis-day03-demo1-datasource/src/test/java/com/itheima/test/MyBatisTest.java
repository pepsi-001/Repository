package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.io.InputStream;
import java.util.ArrayList;
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


    private UserMapper userMapper;

    private SqlSession sqlSession;

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
     * 根据用户信息修改用户
     * User
     *      username!=null  修改
     *      sex==null       不改
     *      address==null   不改
     */
    @Test
    public void testUpdateUserSet(){
        User user = new User();
        user.setId(4);
        user.setSex("男");
        //user.setUsername("小花");
        user.setAddress("中粮");
        user.setBirthday(new Date());

        userMapper.updateUserSet(user);

    }


    /*****
     * 搜索id=1 or id=2  or id=7
     * select * from user where id in (1,2,7)
     */
    @Test
    public void testForeach(){
        List<Integer> ids = new ArrayList<Integer>();
        //ids.add(1);
        //ids.add(2);
        //ids.add(7);
        //使用foreach
        List<User> users = userMapper.getByForeach(ids);

        for (User user : users) {
            System.out.println(user);
        }
    }



    /****
     * 多条件搜索
     *      用户名
     *      性别
     *      address
     *      用户ID
     */
    @Test
    public void testChoose(){
        User user = new User();
        //user.setUsername("王");
        user.setSex("男");
        user.setAddress("北京");
        //user.setId(3);

        List<User> users = userMapper.getUserChoose(user);

        for (User user1 : users) {
            System.out.println(user1);
        }
    }



    /****
     * 多条件搜索
     *      用户名
     *      性别
     *      address
     */
    @Test
    public void testIf(){
        User user = new User();
        //user.setUsername("王");
        //user.setSex("男");
        user.setAddress("北京");

        List<User> users = userMapper.getUserIf(user);

        for (User user1 : users) {
            System.out.println(user1);
        }
    }





    /****
     * 多条件搜索
     *      用户名
     *      性别
     *      address
     */
    @Test
    public void testWhere(){
        User user = new User();
        //user.setUsername("王");
        //user.setSex("男");
        user.setAddress("北京");

        List<User> users = userMapper.getUserWhere(user);

        for (User user1 : users) {
            System.out.println(user1);
        }
    }


    /***
     * 关闭资源
     */
    @After
    public void destroy(){
        //提交事物
        //sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }







}
