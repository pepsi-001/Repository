package com.itheima.mapper;

import com.itheima.domain.Account;

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
     * 根据用户ID查询用户账户信息
     * @param id
     * @return
     */
    List<Account> getAccountByUserId(Integer id);

}
