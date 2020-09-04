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
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    List<User> getByUserName(String username);

    /***
     * 使用${}
     * 修改用户
     * @param user
     * @return
     */
    int updateUserValue(User user);


    /***
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /***
     * 增加用户
     * @param user
     */
    int addUser(User user);

    /***
     * 查询所有
     * @return
     */
    List<User> findAll();

    /***
     * 根据用户名查询用于信息
     * @param username
     * @return
     */
    List<User> getByUserNameValue(String username);
}
