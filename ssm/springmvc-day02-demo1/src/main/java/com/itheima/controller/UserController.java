package com.itheima.controller;

import com.itheima.domain.Student;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
     * 异常捕获测试
     * @return
     */
    @RequestMapping("/error")
    public String execptionHandler(){
        System.out.println("异常由我制造！");
        //制造异常
        int q=10/0;
        return "add_user";
    }


    /***
     * 响应文本数据
     * @return
     */
    @RequestMapping(value = "/response/body/str")
    @ResponseBody
    public String strResponse(){
        return "xiaohonghonghong";
    }

    //视图渲染
    //request.getRequestDispacher("/WEB-INF/pages/1.jsp").forward(request,response);

    /***
     * @ResponseBody:只需要在方法上加该注解，则会响应JSON格式数据
     *                响应说明：如果是一个JavaBean 则响应JSON格式
     *                         如果是基本数据类型或者String，则直接响应文本
     * 响应JSON数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/response/body/json")
    public Student jsonResponse(){
        //创建Student对象
        Student student = new Student();
        student.setHight(2);
        student.setTelephone("1356778888");
        student.setUsername("小熊!");
        return  student;
    }


    /***
     * @RequestBody:前台如果传的数据为JSON
     *              处理：后台直接用对应的JavaBean接收
     *              使用前提：提交方式为POST
     * @return
     */
    @RequestMapping(value = "/request/body/json")
    public String requestBodyJSON(@RequestBody Student student){
        System.out.println(student);
        return "add_user";
    }

    /***
     * @RequestBody:前台如果传的数据为非JSON
     *              处理：username=小红&userage=19
     *              使用前提：提交方式为POST
     * 接收传入的参数
     * @return
     */
    @RequestMapping(value = "/request/body/str")
    public String requestBodyString(@RequestBody String body){
        System.out.println(body);
        return "add_user";
    }


    /***
     * SpringMVC转发
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/mvc/forward")
    public String mvcForward(Model model,HttpServletRequest request){
        //将数据存入Model中
        model.addAttribute("msg","你长得好美！");

        //存入Request作用域
        request.setAttribute("username","小红");

        //并不能使用视图解析器,路径需要写全
        return  "forward:/WEB-INF/pages/add_user.jsp";
    }

    /***
     * 基于SpringMVC实现重定向
     * @return
     */
    @RequestMapping(value = "/mvc/redirect")
    public String mvcRedirect(Model model){
        //将一个数据存入到Model中
        model.addAttribute("username","小红");
        return  "redirect:http://www.itheima.com";
    }


    /****
     * 基于ServletAPI实现请求转发
     * @param request
     * @param response
     */
    @RequestMapping(value = "/servlet/forward")
    public void servletForward(HttpServletRequest request,
                               HttpServletResponse response,
                               Model model) throws ServletException, IOException {
        //将数据存入Model中
        model.addAttribute("msg","你长得好美！");

        //存入Request作用域
        request.setAttribute("username","小红");

        //转发
        request.getRequestDispatcher("/WEB-INF/pages/add_user.jsp").forward(request,response);
    }

    /****
     * 基于ServletAPI实现重定向
     * @return
     */
    @RequestMapping(value = "/servlet/redirect")
    public void servletRedirect(HttpServletResponse response,Model model) throws IOException {
        //将一个数据存入到Model中
        model.addAttribute("username","小红");

        response.sendRedirect("http://www.itheima.com");
    }



    /***
     * 用户列表
     * @return
     */
    @RequestMapping(value = "/model/view")
    public ModelAndView list(){
        //逻辑视图名和数据模型放到一起存储
        ModelAndView modelAndView = new ModelAndView();
        //逻辑数据
        modelAndView.addObject("name","小花花");


        //创建User
        User user1 = new User();
        user1.setName("张三");
        user1.setAge(22);

        User user2 = new User();
        user2.setName("张三");
        user2.setAge(22);

        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        //将一个集合对象存入到ModelAndView中
        modelAndView.addObject("users",users);

        //封装逻辑视图名
        modelAndView.setViewName("list_user");
        //       页面的名字|逻辑视图名
        //return  "list_user";
        return  modelAndView;
    }


    /***
     * 返回void
     * 会跳转到某一个页面：
     */
    @RequestMapping(value = "add")
    public void addUser() {
        System.out.println("hello");

        //            uri  =  /user/add
        // /WEB-INF/pages/user/add.jsp
        //          请求的uri当做逻辑视图名
        //prefix +       逻辑视图名字       +suffix
    }

    /****
     * 向用户输出一段话，不跳转到某个jsp
     *
     * 使用ServletAPI
     *      直接将对应的ServletAPI中的对象当做参数传入即可使用
     */
    @RequestMapping(value = "/add/text")
    public void addUserWriterText(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws IOException {

        System.out.println("void-----");

        //获取一个PrintWriter对象
        PrintWriter writer = response.getWriter();
        writer.write("hello");
        writer.flush();
        writer.close();
        return;
    }

}
