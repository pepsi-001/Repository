package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 16:58
 *
 ****/
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    /***
     * 转账操作
     * @param sourceName    转出账户
     * @param targetName    转入账户
     * @param money         交易金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //根据名字查询转出账户信息
        Account sourceAccount = accountDao.getByName(sourceName);

        //根据名字查询转入账户信息
        Account targetAccount = accountDao.getByName(targetName);

        //转出账户余额-money
        sourceAccount.setMoney(sourceAccount.getMoney()-money);

        //转入账户余额+money
        targetAccount.setMoney(targetAccount.getMoney()+money);

        //修改数据
        accountDao.updateById(sourceAccount);

        int q=10/0;

        accountDao.updateById(targetAccount);

    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
