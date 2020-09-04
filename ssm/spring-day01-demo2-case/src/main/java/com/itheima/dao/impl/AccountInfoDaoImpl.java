package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:36
 *
 ****/
public class AccountInfoDaoImpl implements AccountDao {
    @Override
    public void save(String name) {
        System.out.println("AccountInfoDaoImpl:"+name);
    }
}
