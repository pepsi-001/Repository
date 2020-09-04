package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/11 17:04
 *
 ****/
public interface UserDao {
    User getByUserId(Integer id);

    List<User> getByUserName(String username);

    int addUser(User user);
}
