package com.itheima.service;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:27
 *
 ****/
public interface AccountService {


    /***
     * 发工资
     * @param name
     * @param otherpay
     */
    void payMoney(String name, int otherpay);

    /***
     * 测试方法
     * @param name
     */
    void save(String name);
}
