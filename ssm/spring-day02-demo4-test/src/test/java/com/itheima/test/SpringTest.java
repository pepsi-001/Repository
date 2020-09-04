package com.itheima.test;

import com.itheima.JdbcConfig;
import com.itheima.SpringConfiguration;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 14:57
 * @RunWith(SpringJUnit4ClassRunner.class):配置Spring测试框架引导对象
 * @ContextConfiguration():指定要加载的Spring配置文件或者配置类
 *              classes=SpringConfiguration.class:指定对应的配置类
 *              或者
 *              locations:指定对应的配置文件
 ****/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfiguration.class)
public class SpringTest {


    @Autowired
    private AccountService accountService;

    /***
     * 查询所有
     */
    @Test
    public void testSpring(){
        List<Account> list = accountService.list();
        for (Account account : list) {
            System.out.println(account);
        }
    }


}
