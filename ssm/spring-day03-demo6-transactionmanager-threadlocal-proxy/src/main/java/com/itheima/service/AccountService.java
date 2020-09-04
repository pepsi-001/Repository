package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 15:30
 *
 ****/
public interface AccountService {

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int id);

    Account getById(int id);

    List<Account> list();

    /****
     * 转账操作
     * @param sourceName    转出账户的名字
     * @param targetName    转入账户的名字
     * @param money         交易金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
