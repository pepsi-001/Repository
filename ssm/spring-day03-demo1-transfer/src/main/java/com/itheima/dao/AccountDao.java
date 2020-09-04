package com.itheima.dao;

import com.itheima.domain.Account;

import java.sql.Connection;
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

    void updateAccount(Connection conn,Account account);

    void deleteAccount(int id);

    Account getById(int id);

    List<Account> list();

    /**
     * 根据账户的名字查询账户信息
     * @param name
     * @return
     */
    Account getAccountByName(Connection conn, String name);
}
