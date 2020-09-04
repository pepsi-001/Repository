package com.itheima.controller;

import com.itheima.annotation.RequestMapping;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 14:49
 *
 ****/
@RequestMapping(value = "/cat")
public class CatController {

    /***
     * 增加用户
     * @return
     */
    @RequestMapping(value = "/add",method = "GET")
    public String addUser(){
        return  "/pages/de.jsp";
    }

    /***
     * 查询用户
     * @return
     */
    @RequestMapping(value = "/delete",method = "GET")
    public String getUser(){
        return  "/pages/cat.jsp";
    }

    public void eat(){
        System.out.println("吃饭真好！");
    }

}
