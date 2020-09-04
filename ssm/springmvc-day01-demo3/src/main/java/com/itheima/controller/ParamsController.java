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
@RequestMapping(value = "/params")
public class ParamsController {

    /***
     * params:约束的当前方法接受参数的规则，例如a!=123  表明a不能为123
     * /params/add
     *
     * "a!=123":表示请求参数a的值不能为123
     * "b=998"：b的参数必须=998，必须有b这个参数
     * "!age"：不能有年龄参数
     * "address":必须要有地址参数
     * @return
     */
    @RequestMapping(value = "/add",params ={"a!=123","b=998","!age","address"} )
    public String add(){
        System.out.println("params------------");
        return "add_user";
    }
}
