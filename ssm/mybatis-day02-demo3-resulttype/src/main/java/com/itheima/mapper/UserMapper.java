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
     * 集合查询
     * @return
     */
    List<User> getList();

    /***
     * 查询总记录数
     * @return
     */
    int getCount();
}
