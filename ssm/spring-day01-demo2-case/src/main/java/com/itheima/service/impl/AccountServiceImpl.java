package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:27
 *
 ****/
public class AccountServiceImpl implements AccountService {

    /***
     * 存在依赖
     *
     * 存在硬编码问题
     */
    //对象创建的权利属于AccountServiceImpl自身
    //private AccountDao accountDao = new AccountDaoImpl();
    //private AccountDao accountDao = BeanFactory.getBean("com.itheima.dao.impl.AccountDaoImpl");
    //private AccountDao accountDao = BeanFactory.getBean("com.itheima.dao.impl.AccountInfoDaoImpl");

    //对象创建权利---->给第三方：BeanFactory
    private AccountDao accountDao = BeanFactory.getBean("accountDao");

    /***
     * 测试方法
     * @param name
     */
    @Override
    public void save(String name) {
        System.out.println("AccountServiceImpl:"+name);
        accountDao.save(name);
    }
}
