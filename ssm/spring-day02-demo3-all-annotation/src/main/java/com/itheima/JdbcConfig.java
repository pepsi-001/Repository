package com.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 17:30
 *
 ****/
//@Configuration
public class JdbcConfig {

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${test.hello}")
    private String hello;

    @Value("${test.world}")
    private String world;

    /***
     * 创建一个DataSource对象
     * @Bean:创建一个对象的实例
     *       name:指定一个ID   默认是方法名字
     * @return
     */
    @Bean(name = "dataSource11")
    @Scope(value = "singleton")
    public DataSource createDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setJdbcUrl(url);
            dataSource.setDriverClass(driver);
            System.out.println("hello:"+hello+"...world:"+world);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }


}
