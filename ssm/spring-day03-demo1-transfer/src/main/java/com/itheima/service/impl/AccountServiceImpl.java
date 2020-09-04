package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
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
        accountDao.updateAccount(null,account);
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

    //使用set注入进来
    private ConnectionUtil connectionUtil;

    /***
     * 转账
     * @param sourceName    转出账户的名字
     * @param targetName    转入账户的名字
     * @param money         交易金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //获取连接对象
        Connection conn = connectionUtil.getConnection();
        try {
            //取消自动提交事务
            conn.setAutoCommit(false);

            //查询转出账户信息
            Account sourceAccount = accountDao.getAccountByName(conn,sourceName);    //新建了一个Connection
            //查询转入账户信息
            Account targetAccount = accountDao.getAccountByName(conn,targetName);    //新建了一个Connection

            //转出账户余额-money
            sourceAccount.setMoney(sourceAccount.getMoney()-money);

            //转入账户余额+money
            targetAccount.setMoney(targetAccount.getMoney()+money);

            //提交数据到数据库
            accountDao.updateAccount(conn,sourceAccount);                             //新建了一个Connection

            //int q=10/0;

            accountDao.updateAccount(conn,targetAccount);                            //新建了一个Connection

            //没发生异常，则提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();

            try {
                //事务回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }
}
