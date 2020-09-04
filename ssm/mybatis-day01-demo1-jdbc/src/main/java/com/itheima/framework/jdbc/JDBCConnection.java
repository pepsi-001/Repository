package com.itheima.framework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {


    static {
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 获取数据库连接对象
     * @param
     * @return
     * @date 2020/8/25 11:42
     * @auther Hsheng
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://c33215d134.wicp.vip:47380/ssm?characterEncoding=utf-8", "root", "root");
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }


    /*****
     * 组件：
     * Executor:做数据库操作
     * JDBCConnection:获取数据库连接对象
     * Converter:实现ResultSet结果集转换成对应JavaBean
     */
}
