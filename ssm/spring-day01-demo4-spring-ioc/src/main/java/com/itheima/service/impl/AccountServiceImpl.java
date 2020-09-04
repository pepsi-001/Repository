package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:27
 *
 ****/
public class AccountServiceImpl implements AccountService {


    public AccountServiceImpl() {
        System.out.println("创建对象AccountServiceImpl");
    }

    /***
     * 测试方法
     * @param name
     */
    @Override
    public void save(String name) {
        System.out.println("AccountServiceImpl:"+name);
    }

}
