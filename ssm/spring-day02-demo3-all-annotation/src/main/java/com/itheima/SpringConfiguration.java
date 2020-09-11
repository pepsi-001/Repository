package com.itheima;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 16:41
 *
 ****/
/*@Configuration
@ComponentScan(basePackages = {"com.itheima.dao","com.itheima.service"})
@PropertySource(value = "classpath:jdbc.properties")
@Import(JdbcConfig.class)
@ImportResource(value = "classpath:beans.xml")*/



@Configuration
@ComponentScan(basePackages = {"com.itheima.dao","com.itheima.service"})
@Import(JdbcConfig.class)
@PropertySource({"jdbc.properties","test.properties"})
@ImportResource({"beans.xml"})
public class SpringConfiguration {

    /**
     * @Value(#{""}) 获取其他bean的属性，或者调用其他bean的方法时，只要该bean (Beab_A)能够访问到被调用的bean(Beab_B)，即要么Beab_A 和Beab_B在同一个容器中，或者Beab_B所在容器是Beab_A所在容器的父容器。
     * 过@Value("${}") 可以获取对应属性文件中定义的属性值。假如我有一个sys.properties文件 里面规定了一组值： web.view.prefix =/WEB-INF/views/
     */
    @Value("#{dataSource11}")
    private DataSource ds;


    /***
     * createRunner
     * createDataSource
     * 创建一个QueryRunner对象
     * @return
     */
    @Bean(name = "runner")
    //@Scope(value = "prototype")
    public QueryRunner createRunner(@Qualifier(value = "dataSource11") DataSource dataSource){ //自动注入datasource
        //创建一个QueryRunner对象，并赋值
        QueryRunner queryRunner = new QueryRunner(dataSource);
        System.out.println("createRunner :  "+ ds);
        return queryRunner;
    }




}
