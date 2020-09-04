package com.itheima.singleton;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 14:02
 *
 ****/
public class UserController {

    //懒汉式、饿汉式、罗汉式.......
    private static UserController userController = new UserController();

    private UserController() {
        System.out.println("对象创建....");
    }

    /***
     * 对外公开的方法
     * 用于获取对象的实例
     * @return
     */
    public static UserController newInstance(){
        return  userController;
    }
}
