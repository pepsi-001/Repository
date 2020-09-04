package com.itheima.mapper;

import com.itheima.domain.User;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/14 14:55
 *
 ****/
public interface UserMapper {

    User getByUserId(Integer id);
}
