package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 18:15
 *
 ****/
@Controller
@RequestMapping(value = "/text")
public class TextController {

    /***
     * 保存操作
     * http://localhost:8080/text/save?name=小红&address=深圳
     * @param user
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(User user){
        System.out.println(user);
        return "form";
    }

    /***
     * 数据回显
     * @param model
     * @return
     */
    @RequestMapping(value = "/one")
    public String getById(Model model){
        User user = new User("小白", "白帝城！");
        model.addAttribute("user",user);

        return "form";
    }


    /***
     * 集合输出
     *      map
     *      array
     *      List
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Model model){
        //List
        List<User> users = new ArrayList<User>();
        users.add(new User("小花","北京"));
        users.add(new User("小呆","USA"));
        users.add(new User("小熊","中南海"));
        model.addAttribute("users",users);


        //Map
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("teltephone","136700811111");
        dataMap.put("brand","大华为,小苹果！");
        model.addAttribute("dataMap",dataMap);

        //数组
        String[] city = {"北","上","广","深"};
        model.addAttribute("city",city);

        return "text";
    }




    /***
     * 各种文本输出
     * @return
     */
    @RequestMapping(value = "/content")
    public String content(Model model, HttpSession session, HttpServletRequest request){
        //存储一个文本数据
        model.addAttribute("username","小红");

        //Date类型
        model.addAttribute("now",new Date());

        //创建一个对象
        model.addAttribute("user",new User("小红","深圳"));


        //将数据存入到Session
        session.setAttribute("sessionname","Session小红");

        //将数据存入到Request
        request.setAttribute("requestname","request小红");



        return "text";
    }
}
