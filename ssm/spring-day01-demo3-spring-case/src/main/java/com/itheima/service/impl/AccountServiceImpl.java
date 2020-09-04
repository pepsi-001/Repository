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

    //基本工资
    //private int money=3000;
    //private ThreadLocal<Integer> money=new ThreadLocal<Integer>();

    /***
     * 月薪
     */
    @Override
    public void payMoney(String name,int otherpay){
        int money=3000;
        money+=otherpay;
        System.out.println(name+"这个月的工资是："+money);
    }

    /***
     * 测试方法
     * @param name
     */
    @Override
    public void save(String name) {
        System.out.println("AccountServiceImpl:"+name);
    }

    //对象创建监听方法
    public void init(){
        System.out.println("日志记录：创建"+AccountServiceImpl.class.getName());
    }

    //销毁对象
    public void destroy(){
        System.out.println("日志记录：销毁"+AccountServiceImpl.class.getName());
    }
}
