package com.itheima.mapper;

import com.itheima.domain.Role;
import com.itheima.domain.User;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/12 17:48
 *
 ****/
public interface RoleMapper {

    Role getRoleByUserId(int i);
}
