package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 14:58
 *
 ****/
public interface AccountService {

    /***
     * 增加账号信息
     * @param account
     */
    void save(Account account);

    /***
     * 集合查询
     * @return
     */
    List<Account> list();

}
