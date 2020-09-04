package com.itheima.jdbc;

import java.sql.*;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:18
 *
 ****/
public class Demo {

    public static void main(String[] args) throws Exception {
        /***
         * 1)耦合问题    Class.forName("com.mysql.....");
         * 2)硬编码问题  class--->Demo.java--->com.oracle.odbc.Driver--->javac--->发布
         */
        //1、注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("driver");//key = driver

        //2、获取连接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spring5", "root", "root");
        //3、获取操作数据库的预处理对象PreparedStatment
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM account");
        //4、执行SQL语句，获得结果集
        ResultSet resultSet = pstm.executeQuery();
        //5、遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        //6、关闭资源
        resultSet.close();
        pstm.close();
        conn.close();
    }
}
