package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 14:55
 *
 ****/
public interface AccountDao {
    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int id);

    Account getById(int id);

    List<Account> list();
}
