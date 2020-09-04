package com.itheima.session;

import com.itheima.session.mapper.Mapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 16:59
 *
 ****/
public class Configuration {

    private String username;
    private String password;
    private String driver;
    private String url;

    //数据源
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();

    //SQL语句和返回结果集封装的类型全限定名存储
    private Map<String,Mapper> mappers = new HashMap<String,Mapper>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    //追加每次解析的结果
    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll( mappers );
    }

    /***
     * 获取数据源对象
     * @return
     */
    public DataSource getDataSource(){
        try {
            dataSource.setPassword(password);
            dataSource.setUser(username);
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return  dataSource;
    }

    //获取数据库连接对象
    public Connection getConnection(){
        try {
            //获取连接对象
            Connection conn = getDataSource().getConnection();
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
