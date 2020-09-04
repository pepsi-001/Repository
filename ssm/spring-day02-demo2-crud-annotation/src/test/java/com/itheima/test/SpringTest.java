package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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

    private ClassPathXmlApplicationContext act;

    @Before
    public void init() {
        act = new ClassPathXmlApplicationContext("spring.xml");

    }

    /***
     * 查询所有
     */
    @Test
    public void testGetAll(){
        //AccountService的实例
        AccountService accountService = (AccountService) act.getBean("accountService");

        AccountDao accountDao = (AccountDao) act.getBean("accountDao");


        //容器销毁
        act.close();

    }


}
