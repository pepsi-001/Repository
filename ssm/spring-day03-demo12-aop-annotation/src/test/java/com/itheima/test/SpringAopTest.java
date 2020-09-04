package com.itheima.test;

import com.itheima.SpringConfiguration;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 17:51
 *
 ****/
public class SpringAopTest {

    /***
     * 测试AOP
     */
    @Test
    public void testAop(){
        ApplicationContext act = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = act.getBean(AccountService.class);

        accountService.deleteAccount();
    }

}
