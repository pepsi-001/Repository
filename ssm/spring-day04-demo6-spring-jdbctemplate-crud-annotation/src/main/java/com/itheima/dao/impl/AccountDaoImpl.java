package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.util.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 15:36
 *
 ****/
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> list() {
        return jdbcTemplate.query("select * from account",new AccountRowMapper());
        //return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class)); //需要使用的类型转换器
    }

    @Override
    public Account getByName(String name) {
        return jdbcTemplate.queryForObject(
                "select * from account where name=?",   //SQL语句
                new BeanPropertyRowMapper<Account>(Account.class),//类型转换器
                name);  //SQL语句对应的占位符参数
    }

    @Override
    public int updateById(Account account) {
        return jdbcTemplate.update(
                "update account set name=?,money=? where id=?",
                account.getName(),      //SQL语句对应的占位符参数
                account.getMoney(),     //SQL语句对应的占位符参数
                account.getId());       //SQL语句对应的占位符参数
    }


    /***
     * 所有名字
     */
    @Override
    public List<String> getAllName(){
        return jdbcTemplate.queryForList("select name from account",String.class);
    }

    /***
     * 获取统计数据
     */
    @Override
    public int getCount(){
       return jdbcTemplate.queryForObject("select count(*) from account",Integer.class);
    }


}
