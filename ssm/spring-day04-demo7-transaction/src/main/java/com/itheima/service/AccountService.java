package com.itheima.service;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 16:58
 *
 ****/
public interface AccountService {

    /***
     * 转账实现
     * @param sourceName    转出账户
     * @param targetName    转入账户
     * @param money         交易金额
     */
    void transfer(String sourceName,String targetName,Float money);

}
