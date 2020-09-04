package com.itheima.mapper;

import com.itheima.domain.Account;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/11 17:04
 *
 ****/
public interface AccountMapper {

    /***
     *
     * @param i
     * @return
     */
    Account getAccountList(int i);

    Account getAccountListAssociation(int i);
}
