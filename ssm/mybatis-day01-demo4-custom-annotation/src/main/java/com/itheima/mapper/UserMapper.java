package com.itheima.mapper;

import com.itheima.domain.User;
import com.itheima.session.annotation.Select;

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
    @Select(value = "select * from user")  //Mapper->sql
    List<User> findAll();
    //   Mapper->resultType

}
