package com.itheima.mapper;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 15:00
 *
 ****/
public interface AccountMapper {

    /***
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account> list();

    /***
     * 增加操作
     * @param account
     */
    @Insert("insert into account(name,money)values(#{name},#{money})")
    int add(Account account);
}
