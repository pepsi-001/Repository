package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 14:55
 *
 ****/
public class AccountDaoImpl implements AccountDao {

    /*
    * DBUtils操作数据库的对象
    * */
    private QueryRunner runner;

    //set注入ConnectionUtil
    private ConnectionUtil connectionUtil;

    /****
     * 增加操作
     * JdbcTemplate
     * DBUtils
     * */
    @Override
    public void addAccount(Account account){
        try {
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /****
     * 修改账号
     * @param account
     */
    @Override
    public void updateAccount(Account account){
        try {
            runner.update(connectionUtil.getConnection(),"update account set name=? , money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 根据ID删除数据
     * @param id
     */
    @Override
    public void deleteAccount(int id){
        try {
            runner.update("delete from account where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public Account getById(int id){
        try {
            return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 查询集合
     * @return
     */
    @Override
    public List<Account> list(){
        try {
            return  runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 根据名字查询账户信息
     * @param name
     * @return
     */
    @Override
    public Account getAccountByName(String name) {
        try {
            //假设name唯一，不重复
            return runner.query(connectionUtil.getConnection(),"select * from account where name=?",new BeanHandler<Account>(Account.class),name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }
}
