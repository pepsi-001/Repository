package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
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


    private AccountMapper accountMapper;

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
        accountMapper = sqlSession.getMapper(AccountMapper.class);

        //关闭资源
        is.close();
    }


    /****
     * 查询账号和用户信息
     * 1)SQL语句
     *   SELECT u.username,u.address,u.id userid,u.birthday,u.sex,a.* FROM user u , account a WHERE u.id=a.uid
     * 2)映射关系
     */
    @Test
    public void testOne2One() {
        Account account = accountMapper.getAccountList(1);
        System.out.println(account);
    }

    /***
     * 使用Association实现一对一
     */
    @Test
    public void testAccountListAssociation() {
        Account account = accountMapper.getAccountListAssociation(1);
        System.out.println(account);
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