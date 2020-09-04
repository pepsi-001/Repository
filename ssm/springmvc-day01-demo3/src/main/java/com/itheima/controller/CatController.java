package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 16:23
 *
 ****/
@Controller
@RequestMapping(value = "/cat")
public class CatController {

    /***
     * /user/add
     * method = RequestMethod.GET:表示该方法只接受GET请求
     * @return
     */
    @RequestMapping(value = {"/add","/save"},method = RequestMethod.GET)
    public String addUser(){
        System.out.println("哈哈-addUser--GET");
        return "add_user";
    }


    /***
     * method = RequestMethod.POST:该方法只接受POST请求
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUserPost(){
        System.out.println("哈哈-addUser--POST");
        return "add_user";
    }

}
