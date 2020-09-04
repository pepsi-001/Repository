package com.itheima.test;

import com.itheima.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 14:48
 *      JdbcTemplate使用
 ****/
public class JdbcTemplateTest {

    /***
     * 集合查询
     */
    @Test
    public void testQueryList() throws Exception{
        //创建一个模板对下个
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //设置数据源
        jdbcTemplate.setDataSource(getDataSource());

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
        //创建模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //设置数据源
        jdbcTemplate.setDataSource(getDataSource());

        //执行查询
        Account account = jdbcTemplate.queryForObject("select * from account where id=?" ,new BeanPropertyRowMapper<Account>(Account.class),2);
        System.out.println(account);

    }


    /****
     * 增加测试
     */
    @Test
    public void testAdd() throws Exception{
        //获得JdbcTemplate对象的实例
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //设置数据库连接对象
        jdbcTemplate.setDataSource(getDataSource());

        //通过JdbcTemplate对象的实例实现增删改查
        Account account = new Account();
        account.setName("小花");
        account.setMoney(99f);

        //增加操作   增删改->update
        jdbcTemplate.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }

    /****
     * 创建数据源
     * @return
     * @throws PropertyVetoException
     */
    public ComboPooledDataSource getDataSource() throws PropertyVetoException {
        //创建一个DataSource
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setPassword("root");
        dataSource.setUser("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/spring5");
        return dataSource;
    }

}
