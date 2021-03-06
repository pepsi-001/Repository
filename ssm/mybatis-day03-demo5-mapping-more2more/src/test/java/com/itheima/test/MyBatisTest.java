package com.itheima.test;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 15:39
 *
 ****/
public class MyBatisTest {


    private UserMapper userMapper;

    private RoleMapper roleMapper;

    private SqlSession sqlSession;

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
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        //SqlSession
        //true:自动提交
        //false:手动提交
        sqlSession = sqlSessionFactory.openSession(true);

        //获取UserMapper接口的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
        roleMapper = sqlSession.getMapper(RoleMapper.class);

        //关闭资源
        is.close();
    }


    /****
     * 查询角色
     */
    @Test
    public void testGetRoleOne2More(){
        //一对多映射关系查询
        Role role = roleMapper.getRoleByUserId(3);
        System.out.println(role);
    }

    /****
     * 查询用户，同时将他的账号信息一起查询出来
     */
    @Test
    public void testGetUserOne2More(){
        //一对多映射关系查询
        User user = userMapper.getUserByUserId(2);
        System.out.println(user);
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
