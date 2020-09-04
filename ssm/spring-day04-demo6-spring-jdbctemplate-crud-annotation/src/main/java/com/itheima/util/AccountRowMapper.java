package com.itheima.util;

import com.itheima.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 15:41
 *      自定义映射转换器
 ****/
public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        Float money = rs.getFloat("money");

        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return account;
    }
}
