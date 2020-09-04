package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 18:52
 *
 ****/
@Controller
@RequestMapping(value = "/session")
/***
 * names="name":将Request中的name数据压入到Session
 * types={String.class}:指定当前name所对应的类型(类型即便对比上也不会有问题)
 */
@SessionAttributes(names={"name","age"},types={String.class,Integer.class})
public class SessionAttributesController {

    /***
     * 添加数据到Model中
     * 将数据加入到Model中
     * 也加入到Request中
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(Model model){
        model.addAttribute("name","root");
        model.addAttribute("age","20");
        return "session_attributes";
    }

    /***
     * 后台获取数据
     * @param map
     * @return
     */
    @RequestMapping(value = "/get")
    public String getSession(ModelMap map,HttpSession session){
        Object name = map.get("name");
        System.out.println(name);

        System.out.println(session.getAttribute("age"));
        return "session_attributes";
    }


    /***
     * 让Session失效
     * @param sessionStatus
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(SessionStatus sessionStatus){

        //设置之后，Session会失效
        sessionStatus.setComplete();
        return "session_attributes";
    }


    /***
     * 查看页面是否有数据
     * @return
     */
    @RequestMapping(value = "/page")
    public String page(){
        return "session_attributes";
    }

}
