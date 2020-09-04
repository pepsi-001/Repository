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
     * 根据用户ID查询账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> getByUserId(Integer uid);

}
