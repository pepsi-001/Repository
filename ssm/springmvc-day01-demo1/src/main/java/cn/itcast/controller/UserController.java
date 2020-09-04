package cn.itcast.controller;

import cn.itcast.framework.annotation.RequestMapping;
import cn.itcast.model.User;

import javax.servlet.http.HttpServletRequest;

/***
 * 用户控制层
 */
@RequestMapping(value = "/user")
public class UserController {

    /***
     * 增加用户  /user/add
     * @return
     */
    @RequestMapping(value = "/add")
    public String addUser(){
        System.out.println("hello!,将被增加到数据库去!");
        return "user";
    }

    /***
     * 获得用户信息   /user/list
     * @return
     */
    @RequestMapping(value = "/list")
    public String getUser(){
        System.out.println("userid");
        return "user";
    }
}
