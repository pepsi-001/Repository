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
     * 增加数据
     */
    @Insert("insert into user(username,sex,birthday,address)values(#{username},#{sex},#{birthday},#{address})")
    int add(User user);

    /***
     * 修改操作
     * @param user
     * @return
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    int modify(User user);


    /***
     * 根据用户ID 删除
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    int deleteByUserId(int id);

    /***
     * 根据名字模糊查询
     * @param username
     * @return
     */
    //@Select("select * from user where username like '%${value}%'")
    @Select("select * from user where username like #{value}")
    List<User> getByUserName(String username);

    /***
     * 根据用户名字和性别查询
     * @param username
     * @param sex
     * @return
     */
    @Select("select * from user where username like #{username} and sex=#{sex}")
    List<User> getByUserNameAndSex(@Param("username")String username, @Param("sex")String sex);


}
