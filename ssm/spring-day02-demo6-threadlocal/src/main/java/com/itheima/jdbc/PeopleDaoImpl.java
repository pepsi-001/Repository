package com.itheima.jdbc;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 17:54
 *
 ****/
public class PeopleDaoImpl {


    private ThreadLocal<Integer> connection = new ThreadLocal<Integer>();

    public int getConnection() {
        return connection.get();
    }

    public void setConnection(int connection) {
        this.connection.set(connection);
    }
}
