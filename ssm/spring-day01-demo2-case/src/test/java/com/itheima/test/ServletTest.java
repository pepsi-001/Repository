package com.itheima.test;

import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;
import com.itheima.singleton.UserController;
import org.junit.Test;


/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:30
 *
 ****/
public class ServletTest {

    /***
     * new 一个对象
     *
     * 存在硬编码
     */
    //private AccountService accountService = new AccountServiceImpl();
    //private AccountService accountService = BeanFactory.getBean("com.itheima.service.impl.AccountServiceImpl");
    private AccountService accountService1 = BeanFactory.getBean("accountService");
    private AccountService accountService2 = BeanFactory.getBean("accountService");

    /***
     * 测试
     */
    @Test
    public void testSave(){
        accountService1.save("小红");

        System.out.println(accountService1==accountService2);
    }


    /***
     * 单利测试
     */
    @Test
    public void testSingleton(){
        UserController userController1 = UserController.newInstance();
        UserController userController2 = UserController.newInstance();

        System.out.println(userController1 == userController2);

    }

}
