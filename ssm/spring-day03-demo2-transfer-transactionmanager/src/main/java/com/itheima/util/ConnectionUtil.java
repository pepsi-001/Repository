package com.itheima.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 15:11
 *      管理连接对象
 ****/
public class ConnectionUtil {

    //使用set注入
    private DataSource dataSource;

    private Connection conn;

    /***
     * 获取连接对象
     * @return
     */
    public Connection getConnection(){
        try {
            if(conn==null){
                conn = dataSource.getConnection();
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
