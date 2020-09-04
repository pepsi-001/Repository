package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/11 17:04
 *
 ****/
public class UserDaoImpl implements UserDao {

    //定义一个SqlSessionFactory，作用是创建SqlSession
    private SqlSessionFactory sqlSessionFactory;

    //给SqlSessionFactory赋值
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public User getByUserId(Integer id) {
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用查询（单个对象）
        User user = sqlSession.selectOne("UserNamespace.getByUserId", id);

        //关闭资源
        sqlSession.close();
        return user;
    }

    /***
     * 根据名字模糊查询
     * @param username
     * @return
     */
    @Override
    public List<User> getByUserName(String username) {
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用指定查询
        List<User> users = sqlSession.selectList("UserNamespace.getByUserName",username);

        //关闭资源
        sqlSession.close();
        return users;
    }

    /***
     * 增加用户
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用增加操作
        int acount = sqlSession.insert("UserNamespace.addUser",user);

        //提交事物
        sqlSession.commit();

        //关闭资源
        sqlSession.close();
        return acount;
    }


}
