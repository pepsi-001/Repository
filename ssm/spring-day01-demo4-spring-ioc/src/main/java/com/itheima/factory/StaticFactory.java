package com.itheima.factory;

import com.itheima.service.impl.AccountServiceImpl;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 16:57
 *          静态工厂
 ****/
public class StaticFactory {

    /***
     * 静态工厂方法
     * @return
     */
    public static AccountServiceImpl createAccountService(){
        return  new AccountServiceImpl();
    }

}
