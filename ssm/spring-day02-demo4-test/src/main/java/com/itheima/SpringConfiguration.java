package com.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 16:41
 *
 ****/
@Configuration
@ComponentScan(basePackages = {"com.itheima.dao","com.itheima.service"})
@PropertySource(value = "classpath:jdbc.properties")
@Import(JdbcConfig.class)
@ImportResource(value = "classpath:beans.xml")
public class SpringConfiguration {





    /***
     * createRunner
     * createDataSource
     * 创建一个QueryRunner对象
     * @return
     */
    @Bean(name = "runner")
    //@Scope(value = "prototype")
    public QueryRunner createRunner(@Qualifier(value = "dataSource") DataSource dataSource){
        //创建一个QueryRunner对象，并赋值
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }




}
