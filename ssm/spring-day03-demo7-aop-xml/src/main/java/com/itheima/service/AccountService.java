package com.itheima.service;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 17:25
 *
 ****/
public interface AccountService {

    /**
     * 模拟保存
     */
    void saveAccount();

    /**
     * 模拟更新
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除
     * @return
     */
    int deleteAccount();
}
