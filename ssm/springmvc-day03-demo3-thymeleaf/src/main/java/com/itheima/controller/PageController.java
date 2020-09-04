package com.itheima.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 18:09
 *
 ****/
@Controller
@RequestMapping(value = "/page")
public class PageController {


    /***
     * 通用页面跳转
     * @param page
     * @return
     */
    @RequestMapping(value = "/{page}")
    public String page(@PathVariable(value = "page")String page){
        return  page;
    }

}
