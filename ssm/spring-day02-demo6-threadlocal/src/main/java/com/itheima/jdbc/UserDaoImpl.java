package com.itheima.jdbc;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 17:54
 *
 ****/
public class UserDaoImpl {

    public int connection=1;

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }
}
