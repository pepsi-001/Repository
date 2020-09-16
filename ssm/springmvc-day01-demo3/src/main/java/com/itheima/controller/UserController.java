package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 16:23
 *
 ****/
@Controller //当前类（UserController）给Spring IOC容器管理
@RequestMapping(value = "/user")        //映射关系
public class UserController {

    /***
     * /user/add
     * 增加用户操作
     * @return
     */
    @RequestMapping(value = "/add")
    public String addUser() {
        System.out.println("哈哈-add");
        //return "/WEB-INF/pages/add_user.jsp";
        ///WEB-INF/pages/
        //                          .jsp
        return "add_user";  // user_add：逻辑视图
    }

}
