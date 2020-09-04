package com.itheima.mapper;

import com.itheima.domain.User;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/12 17:48
 *
 ****/
public interface UserMapper {

    /***
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getByUserName(String username);


}
