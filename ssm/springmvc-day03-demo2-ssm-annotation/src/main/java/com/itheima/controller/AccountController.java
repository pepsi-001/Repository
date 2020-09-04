package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 15:03
 *
 ****/
@Controller
@RequestMapping(value = "/account")
public class AccountController {


    @Autowired
    private AccountService accountService;


    /****
     * 增加操作
     * @param name
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(String name){
        Account account= new Account(name,999d);

        //增加
        accountService.save(account);

        return  "list";
    }

    /***
     * 账号列表查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public List<Account> list(){
        List<Account> list = accountService.list();
        return list;
    }


    /***
     * 响应JSON数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json")
    public Account json(){
        Account account = new Account(123,"小红",998d);
        return account;
    }


}
