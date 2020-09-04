package com.itheima.test;

import com.itheima.JdbcConfig;
import com.itheima.SpringConfiguration;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 14:57
 *
 ****/
public class SpringTest {



    /***
     * 查询所有
     */
    @Test
    public void testSpring(){
        //使用注解方式创建Spring的IOC容器
       ApplicationContext act = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        String[] names = act.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        AccountService accountService = act.getBean(AccountService.class);
        List<Account> list = accountService.list();

        for (Account account : list) {
            System.out.println(account);
        }

        QueryRunner runner1 = act.getBean(QueryRunner.class);
        QueryRunner runner2 = act.getBean(QueryRunner.class);

        System.out.println(runner1 == runner2);
    }


}
