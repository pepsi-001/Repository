package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 16:23
 *
 ****/
@Controller
@RequestMapping(value = "/parameters")
public class ParametersController {


    /****
     * Model的使用
     * @param model
     * @return
     */
    @RequestMapping(value = "/model")
    public String add(Model model){
        model.addAttribute("USErNAMEINFO_ITHEIM","张三");
        return "add_user";
    }

    /****
     * @ModelAttribute：优先执行
     *                   无返回值
     *  @ModelAttribute：用于初始化一些参数
     * @param dataMap
     */
    @ModelAttribute
    public void maInit(Map<String,Object> dataMap){
        User user = new User();
        user.setName("小红");
        dataMap.put("u",user);
    }


    /***
     * 结合@ModelAttribute一起使用(@ModelAttribute：作用在参数上)
     * @ModelAttribute:引用了另外一个对象
     * @param user
     * @return
     */
    @RequestMapping(value = "/ma/addp")
    public String addUserMaParameter(@ModelAttribute("u")User user){
        System.out.println(user);
        return  "add_user";
    }


    /*==============================================================*/

    /****
     * @ModelAttribute：作用在方法上
     *                    首先执行该注解对应的方法
     * @return
     */
    //@ModelAttribute
    public User mattribute(){
        User user = new User();
        user.setName("小红");
        return  user;
    }

    /***
     * 结合@ModelAttribute一起使用
     * @param user
     * @return
     */
    @RequestMapping(value = "/ma/add")
    public String addUserMa(User user){
        System.out.println(user);
        return  "add_user";
    }



    /***
     * @CookieValue:用户获取Cookie信息
     * @CookieValue(value = "JSESSIONID"):表明获取Cookie的key为JSESSIONID的值
     * @return
     */
    @RequestMapping(value = "/cookie/value")
    public String cookieValue(@CookieValue(value = "JSESSIONID")String jsid){
        System.out.println(jsid);
        return  "add_user";
    }

    /***
     * @RequestHeader(value = "Host"):获取请求头信息，Host表示获取请求头中Host信息
     * @param host
     * @return
     */
    @RequestMapping(value = "/header")
    public String getHeader(@RequestHeader(value = "Host")String host){
        System.out.println(host);
        return "add_user";
    }

    /***
     * @PathVariable:将路径中的部分截取出来，作为变量
     * value = "id":截取站位为id的路径的值
     * /parameters/path/variable/41-136700813333.html
     * @return
     */
    @RequestMapping(value = "/path/variable/{id}-{telephone}")
    public String pathVariable(@PathVariable(value = "id")Long id,
                               @PathVariable(value = "telephone")String telephone){
        System.out.println("ID:"+id+",Telephone:"+telephone);
        return "add_user";
    }


    /***
     * @RequestBody:如果前台提交数据是JSON类型，则后台可以直接用User对象接收
     * 接收前台传递的数据
     *      前台提交方式必须为Post
     * @param body
     * @return
     */
    @RequestMapping(value = "/request/body",method = RequestMethod.POST)
    public String addUserRequestBody(@RequestBody String body){
        System.out.println(body);
        return "add_user";
    }


    /****
     * name:前台参数
     * @RequestParam:默认参数必填
     * required = true:该参数不允许为空
     * defaultValue = "18":默认值(当该参数没有传入的时候生效)
     * value = "xiaohong":页面传过来的参数名字
     * @return
     */
    @RequestMapping(value = "/requst/param")
    public String requestParame(@RequestParam(value = "name",required = true) String name,
                                @RequestParam(value = "xiaohong",required = false,defaultValue = "18")Integer age){
        System.out.println(name);
        System.out.println(age);
        return  "add_user";
    }

    /***
     * 解决date问题
     * 使用到了自定义类型转换器
     * @return
     */
    @RequestMapping(value = "/date/add")
    public String date(User user){
        System.out.println(user);
        return "add_user";
    }


    /***
     * 接受一个一对多映射关系
     * @return
     */
    @RequestMapping(value = "/one2more/add")
    public String one2more(User user){
        System.out.println(user);
        return "add_user";
    }


    /***
     * 接受一个一对一映射关系
     * @return
     */
    @RequestMapping(value = "/one2one/add")
    public String one2one(User user){
        System.out.println(user);
        return "add_user";
    }


    /***
     * 接受一个List
     * 需要加@RequestParam
     * @return
     */
    @RequestMapping(value = "/list/add")
    public String map(@RequestParam List<Long> id){
        for (Long aLong : id) {
            System.out.println(aLong);
        }
        return "add_user";
    }



    /***
     * 接受一个Map
     * 需要加@RequestParam
     * @return
     */
    @RequestMapping(value = "/map/add")
    public String map(@RequestParam Map map){
        System.out.println(map);
        return "add_user";
    }

    /***
     * 接受一个JavaBean
     * @return
     */
    @RequestMapping(value = "/bean/add")
    public String add(User user){
        System.out.println(user);
        return "add_user";
    }


    /***
     * 接受String和基本数据类型
     * name
     * age
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(String name,int age){
        System.out.println(name+"---"+age);
        return "add_user";
    }



}
