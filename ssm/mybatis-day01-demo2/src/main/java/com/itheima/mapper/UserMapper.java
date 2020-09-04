package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 15:30
 *
 ****/
public interface UserMapper {

    /***
     * 查询所有
     * @return
     */
    List<User> findAll();

}
