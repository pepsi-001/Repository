package com.itheima.test;

import com.itheima.domain.User;
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

        //关闭会话资源
        is.close();
    }


    /****
     * 返回一个列表
     */
    @Test
    public void testGetList(){
        //statement  Mapper.xml中对应id的SQL位置
        //statement=namespace.id
       List<User> users = sqlSession.selectList("xiaohei.getList");
        for (User user : users) {
            System.out.println(user);
        }
    }


    /****
     * 返回一个列表
     */
    @Test
    public void testGetByUserName(){
        //statement  Mapper.xml中对应id的SQL位置
        //statement=namespace.id
        List<User> users = sqlSession.selectList("xiaohei.getByUserName","%王%");
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
