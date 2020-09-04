package com.itheima.mapper;

import com.itheima.domain.Account;

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
    List<Account> list();
}
