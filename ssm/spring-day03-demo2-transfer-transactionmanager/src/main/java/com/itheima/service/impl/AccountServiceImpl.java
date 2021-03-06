package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.util.TransactionManager;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 15:30
 *
 ****/
public class AccountServiceImpl implements AccountService {
    /*
     * 注入Dao
     * */
    private AccountDao accountDao;

    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public Account getById(int id) {
        return accountDao.getById(id);
    }

    @Override
    public List<Account> list() {
        return accountDao.list();
    }

    //使用set方法注入
    private TransactionManager txtManager;


    /***
     * 转账
     * @param sourceName    转出账户的名字
     * @param targetName    转入账户的名字
     * @param money         交易金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //开启事务
            txtManager.beginTransaction();

            //查询转出账户信息
            Account sourceAccount = accountDao.getAccountByName(sourceName);    //新建了一个Connection
            //查询转入账户信息
            Account targetAccount = accountDao.getAccountByName(targetName);    //新建了一个Connection

            //转出账户余额-money
            sourceAccount.setMoney(sourceAccount.getMoney()-money);

            //转入账户余额+money
            targetAccount.setMoney(targetAccount.getMoney()+money);

            //提交数据到数据库
            accountDao.updateAccount(sourceAccount);                             //新建了一个Connection

            int q=10/0;

            accountDao.updateAccount(targetAccount);                            //新建了一个Connection

            //没发生异常，则提交事务
            txtManager.commit();
        } catch (Exception e) {
            e.printStackTrace();

            //事务回滚
            txtManager.rollback();
        }finally {
            //关闭资源
            txtManager.close();
        }
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxtManager(TransactionManager txtManager) {
        this.txtManager = txtManager;
    }
}
