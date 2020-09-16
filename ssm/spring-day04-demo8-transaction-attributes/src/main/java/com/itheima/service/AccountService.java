package com.itheima.service;

import com.itheima.domain.Account;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 16:58
 *
 ****/
public interface AccountService {

    /***
     * 根据ID查询账户信息
     * @param id
     * @return
     */
    Account getAccountById(Integer id);

    /***
     * 转账实现
     * @param sourceName    转出账户
     * @param targetName    转入账户
     * @param money         交易金额
     */
    void transfer(String sourceName,String targetName,Float money) throws InterruptedException;

}
