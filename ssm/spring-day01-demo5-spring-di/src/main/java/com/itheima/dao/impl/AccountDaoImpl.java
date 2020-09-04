package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:28
 *
 ****/
public class AccountDaoImpl implements AccountDao {





    /***
     * 测试方法
     * @param name
     */
    @Override
    public void save(String name) {
        System.out.println("AccountDaoImpl:"+name);
    }
}
