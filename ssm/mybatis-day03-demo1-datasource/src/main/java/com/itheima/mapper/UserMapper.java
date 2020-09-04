package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/11 17:04
 *
 ****/
public interface UserMapper {

    List<User> getUserIf(User user);

    List<User> getUserChoose(User user);

    List<User> getUserWhere(User user);

    List<User> getByForeach(List<Integer> ids);

    void updateUserSet(User user);
}
