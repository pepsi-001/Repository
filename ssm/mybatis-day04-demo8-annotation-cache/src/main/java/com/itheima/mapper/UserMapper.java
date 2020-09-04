package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/15 16:08
 *
 ****/
@CacheNamespace
public interface UserMapper {

    /***
     * 根据用户名字查询用户信息
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    @Results(
            value = {
                    @Result(
                            property = "accounts",
                            column = "id",
                            //一对多映射关系
                            many = @Many(
                                    select = "com.itheima.mapper.AccountMapper.getByUserId",
                                    fetchType = FetchType.LAZY
                            )
                    )
            }
    )
    User getByUserName(String username);


}
