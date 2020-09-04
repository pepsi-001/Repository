package com.itheima.test;

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

    /***
     * 查询所有测试
     */
    @Test
    public void testFindAll() throws Exception{
        //调用接口对应的方法实现查询
        List<User> users = userMapper.findAll();

        //输出结果集
        for (User user : users) {
            System.out.println(user);
        }
    }


    /***
     * 增加测试
     */
    @Test
    public void testAddUser() throws Exception{
        User user = new User();
        user.setUsername("pepsi");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京");
        userMapper.addUser(user);
        System.out.println(user.getId());

        //日志记录
        logger.info(user);
    }


    /****
     * 修改用户
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUsername("王二大11");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("天津");
        user.setId(7);
        //修改
        userMapper.updateUser(user);
        //logger.info(user);
    }

    /****
     * 使用${}
     * 修改用户
     */
    @Test
    public void testUpdateUserValue(){
        User user = new User();
        user.setUsername("小王");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南");
        user.setId(7);

        //修改
        userMapper.updateUserValue(user);
    }


    /***
     * 根据用户名模糊查询
     * #{}
     */
    @Test
    public void testGetByUserName(){
        String username = "%王%";
        List<User> users = userMapper.getByUserName(username);
        for (User user : users) {
            System.out.println(user);
        }
    }


    /***
     * 根据用户名模糊查询
     * ${}
     */
    @Test
    public void testGetByUserNameValue(){
        String username = "王";
        List<User> users = userMapper.getByUserNameValue(username);
        for (User user : users) {
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
