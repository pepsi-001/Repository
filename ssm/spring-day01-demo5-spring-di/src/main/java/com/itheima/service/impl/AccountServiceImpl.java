package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;

import java.util.Date;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:27
 *
 ****/
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl() {
    }

    /***
     * 带参数的构造函数
     * @param name
     * @param age
     */
    public AccountServiceImpl(String name, Integer age,Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday=birthday;
    }

    /***
     * 测试方法
     * @param name
     */
    @Override
    public void save(String name) {
        System.out.println("AccountServiceImpl:"+name);
        System.out.println(this.name+"---"+this.age+"=="+birthday);
    }


    /*
    * 用于set注入值
    * */
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
