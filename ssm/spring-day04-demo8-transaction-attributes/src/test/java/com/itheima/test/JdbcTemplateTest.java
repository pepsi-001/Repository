package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void testTransfer() throws InterruptedException {
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
