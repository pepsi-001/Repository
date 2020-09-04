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

    //创建一个ThreadLocal，解决成员变量安全问题
    private ThreadLocal<Connection> connection = new ThreadLocal<Connection>();

    /***
     * 获取连接对象
     * @return
     */
    public Connection getConnection(){
        try {
            //从ThreadLocal中获取连接对象
            Connection thconn = this.connection.get();

            //若果没有连接对象，则新建一个连接
            if(thconn==null){
                //新建的链接对象
                thconn = dataSource.getConnection();

                //将新建的链接对象存入ThreadLocal
                connection.set(thconn);
            }
            //返回链接对象
            return thconn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭链接的时候移除ThreadLocal中的链接对象
    public void remove(){
        connection.remove();
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
