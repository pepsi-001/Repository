package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 14:57
 *
 ****/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml") //classpath不能缺
public class SpringTest {

    @Autowired
    private AccountService accountService;

    /***
     * 查询所有
     */
    @Test
    public void testGetAll(){
        List<Account> list = accountService.list();
        for (Account account : list) {
            System.out.println(account);
        }
    }


}
