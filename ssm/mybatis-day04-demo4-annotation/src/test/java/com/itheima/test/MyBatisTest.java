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


    /***
     * 根据用户名字和性别查询用户信息
     */
    @Test
    public void getByUserNameAndSex() {
        List<User> users = userMapper.getByUserNameAndSex("%王%","女");
        for (User user : users) {
            System.out.println(user);
        }
    }
    /***
     * 查询用户信息
     */
    @Test
    public void testGetByUserName() {
        List<User> users = userMapper.getByUserName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /***
     * 根据ID删除数据
     */
    @Test
    public void testDeleteByUserId() {
        int id = 6;
        userMapper.deleteByUserId(id);
    }


    /***
     * 修改测试
     */
    @Test
    public void testModify() {
        User user = new User();
        user.setBirthday(new Date());
        user.setAddress("武汉");
        user.setUsername("大芳");
        user.setSex("女");
        user.setId(6);

        userMapper.modify(user);
    }

    /***
     * 增加测试
     */
    @Test
    public void testAdd() {
        User user = new User();
        user.setBirthday(new Date());
        user.setAddress("深圳");
        user.setUsername("小芳");
        user.setSex("女");

        userMapper.add(user);
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
