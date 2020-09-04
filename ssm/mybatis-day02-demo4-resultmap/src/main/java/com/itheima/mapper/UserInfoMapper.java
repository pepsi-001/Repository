package com.itheima.mapper;

import com.itheima.domain.UserInfo;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 15:30
 *
 ****/
public interface UserInfoMapper {

    /***
     * 集合查询
     * @return
     */
    List<UserInfo> getList();

    /***
     * 集合查询
     * @return
     */
    List<UserInfo> getListResultMap();


    void add(UserInfo userInfo);
}
