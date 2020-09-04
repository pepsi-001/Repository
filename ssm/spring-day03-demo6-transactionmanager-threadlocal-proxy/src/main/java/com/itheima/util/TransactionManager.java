package com.itheima.util;

import java.sql.Connection;
import java.sql.SQLException;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 15:31
 *      管理事务
 ****/
public class TransactionManager {

    //注入ConnectionUtil
    private ConnectionUtil connectionUtil;

    //开启事务
    public void beginTransaction(){
        try {
            connectionUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //提交事务
    public void commit(){
        try {
            connectionUtil.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //回滚事务
    public void rollback(){
        try {
            connectionUtil.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭资源
    public void close(){
        try {
            //关闭链接(归还给连接池)
            connectionUtil.getConnection().close();
            //移除ThreadLocal中的链接
            connectionUtil.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }
}
