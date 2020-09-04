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

    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        accountService = (AccountService) act.getBean("accountService");
    }

    /***
     * 测试Spriung容器
     */
    @Test
    public void testSpringContext() {
        //创建Spring容器
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");

        //从容器中获取对象的实例
        //AccountDao accountDao = (AccountDao) act.getBean("accountDao");

        //根据类型获取对象的实例
        AccountDao accountDao = act.getBean(AccountDao.class);
        System.out.println(accountDao);

        for (String name : act.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    /***
     * 增加
     */
    @Test
    public void testAdd(){
        Account account = new Account();
        account.setMoney(99.9f);
        account.setName("zhangsan");

        accountService.addAccount(account);

    }


    /***
     * 修改测试
     */
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setMoney(10.9f);
        account.setName("lisi");
        account.setId(3);

        accountService.updateAccount(account);

    }


    /***
     * 删除测试
     */
    @Test
    public void testDelete(){
        accountService.deleteAccount(3);
    }


    /***
     * 根据ID查询测试
     */
    @Test
    public void testGetById(){
        Account account = accountService.getById(2);
        System.out.println(account);
    }



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
