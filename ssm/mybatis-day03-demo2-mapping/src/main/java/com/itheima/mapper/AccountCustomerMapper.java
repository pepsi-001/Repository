package com.itheima.mapper;

import com.itheima.domain.AccountCustomer;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/11 17:04
 *
 ****/
public interface AccountCustomerMapper {

    /****
     * 集成方式查询1对1
     * @return
     */
    List<AccountCustomer> getAccountCustomer();
}
