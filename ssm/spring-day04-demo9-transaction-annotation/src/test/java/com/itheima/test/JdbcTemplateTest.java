package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 14:48
 *      JdbcTemplate使用
 ****/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class JdbcTemplateTest {

    @Autowired
    private AccountService accountService;

    /***
     * 转账
     */
    @Test
    public void testTransfer(){
        accountService.transfer("小红","小白",100f);
    }


    /***
     * 转账
     */
    @Test
    public void testGetAccountById(){
        Account account = accountService.getAccountById(1);
    }

}
