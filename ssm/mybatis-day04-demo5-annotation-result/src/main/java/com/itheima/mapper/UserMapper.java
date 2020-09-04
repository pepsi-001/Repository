package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/12 17:48
 *
 ****/
public interface UserMapper {


    /***
     * 根据用户名字和性别查询
     * @param username
     * @param sex
     * @return
     * select user_id,user_name,user_sex,user_birthday,user_address from userinfo
     * User:     id,   username,  sex,      birthday,     address
     */
    @Select("select * from userinfo where user_name like #{username} and user_sex=#{sex}")
    @Results(
            id="resultMapUser",
            value = {
                    @Result(column = "user_id",property = "id",id = true),
                    @Result(column = "user_name",property = "username"),
                    @Result(column = "user_sex",property = "sex"),
                    @Result(column = "user_birthday",property = "birthday"),
                    @Result(column = "user_address",property = "address")
            }
    )
    List<User> getByUserNameAndSex(@Param("username")String username, @Param("sex")String sex);


    /***
     * 查询
     * @param id
     * @return
     */
    @Select("select * from userinfo where user_id=#{id}")
    @ResultMap("resultMapUser")
    User getByUserId(Integer id);
}
