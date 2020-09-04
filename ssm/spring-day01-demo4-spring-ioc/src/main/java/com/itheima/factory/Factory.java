package com.itheima.factory;

import com.itheima.service.impl.AccountServiceImpl;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 16:57
 *          普通工厂
 ****/
public class Factory {

    /***
     * 普通工厂方法
     * @return
     */
    public AccountServiceImpl createAccountService(){
        return  new AccountServiceImpl();
    }

}
