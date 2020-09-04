package com.itheima.mapper;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/11 17:04
 *
 ****/
public interface AccountMapper {

    /***
     * 根据账号ID查询账号信息同时查询用户信息
     */
    @Select("select * from account where id=#{id}")
    @Results(
            value = {
                    @Result(
                            property = "user",
                            column = "uid",
                            //一对一
                            one=@One(select = "com.itheima.mapper.UserMapper.getUserById",fetchType = FetchType.EAGER)
                    )
            }
    )
    Account getAccountById(Integer id);
}
