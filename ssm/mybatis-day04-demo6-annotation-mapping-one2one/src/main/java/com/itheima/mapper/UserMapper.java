package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/15 16:08
 *
 ****/
public interface UserMapper {

    /***
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);
}
