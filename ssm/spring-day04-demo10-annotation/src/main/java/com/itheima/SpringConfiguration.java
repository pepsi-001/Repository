package com.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 18:28
 *
 ****/
@Configuration
@ComponentScan(basePackages = "com")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {

    @Value("${dataSource.jdbcUrl}")
    private String jdbcurl;

    @Value("${dataSource.driverClass}")
    private String driverClass;

    @Value("${dataSource.user}")
    private String user;

    @Value("${dataSource.password}")
    private String password;

    /***
     * 创建JdbcTemplate
     * @param dataSource
     * @return
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }


    /***
     * 创建事务管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "txtManager")
    public DataSourceTransactionManager createTxtManager(DataSource dataSource){
        //创建事务管理器对象
        DataSourceTransactionManager txtManager = new DataSourceTransactionManager();
        txtManager.setDataSource(dataSource);

        return txtManager;
    }


    /***
     * 创建数据源
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSouce(){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl(jdbcurl);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setDriverClass(driverClass);

            return dataSource;
        } catch (PropertyVetoException e) {
            throw  new RuntimeException(e);
        }
    }

}
