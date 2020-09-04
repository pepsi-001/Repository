package com.itheima.service.impl;

import com.itheima.service.AccountService;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 17:25
 *
 ****/
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount(int a) {
        System.out.println("saveAccount-----");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("updateAccount-----");
    }

    @Override
    public int deleteAccount() {
        System.out.println("deleteAccount-----");
        return 1;
    }
}
