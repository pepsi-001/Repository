package com.itheima.test;

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
    private JdbcTemplate jdbcTemplate;

    /***
     * 集合查询
     */
    @Test
    public void testQueryList() throws Exception{
        //执行查询
        List<Account> accounts = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));

        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /***
     * 查询一个数据
     */
    @Test
    public void testQueryById() throws Exception{
        //执行查询
        Account account = jdbcTemplate.queryForObject("select * from account where id=?" ,new BeanPropertyRowMapper<Account>(Account.class),2);
        System.out.println(account);

    }


    /****
     * 增加测试
     */
    @Test
    public void testAdd() throws Exception{
        //通过JdbcTemplate对象的实例实现增删改查
        Account account = new Account();
        account.setName("小花");
        account.setMoney(99f);

        //增加操作   增删改->update
        jdbcTemplate.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }



}
