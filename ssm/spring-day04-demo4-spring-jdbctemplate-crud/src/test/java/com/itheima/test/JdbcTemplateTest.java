package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
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
    private AccountDao accountDao;

    /***
     * 查询所有
     */
    @Test
    public void testList(){
        List<Account> list = accountDao.list();
        for (Account account : list) {
            System.out.println(account);
        }
    }


    /***
     * 根据名字查询
     */
    @Test
    public void testGetByName(){
        Account account = accountDao.getByName("小花");
        System.out.println(account);
    }


    /***
     * 修改数据
     */
    @Test
    public void testUpdateById(){
        //Account{id=3, name='小花', money=99.0}
        Account account = new Account();
        account.setId(3);
        account.setName("小花花");
        account.setMoney(200f);

        accountDao.updateById(account);
    }


    /***
     * 获取某一列的所有值
     */
    @Test
    public void testGetAllName(){
        List<String> names = accountDao.getAllName();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /***
     * 测试获取统计数据
     */
    @Test
    public void testGetCount(){
        int count = accountDao.getCount();
        System.out.println(count);
    }




}
