package com.paic.controller;

import com.paic.controller.frontend.MainPageController;
import com.paic.controller.superadmin.HeadLineOperationController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         *  request path is: /hello/框架
         *  request URL is: http://localhost:8080/simpleframework/hello/%E6%A1%86%E6%9E%B6
         *  URLDecoder解码后 request path is: http://localhost:8080/simpleframework/hello/框架
         *  request URI is: /simpleframework/hello/%E6%A1%86%E6%9E%B6
         *  request method is: GET
         */
        System.out.println("request path is: "+req.getServletPath());
        System.out.println("request URL is: "+ req.getRequestURL());
        System.out.println("URLDecoder解码后 request path is: "+ URLDecoder.decode(String.valueOf(req.getRequestURL()),"UTF-8"));
        System.out.println("request URI is: "+req.getRequestURI());
        System.out.println("request method is: "+req.getMethod());
        if (req.getServletPath()=="frontend/getmainpageinfo"&&req.getMethod()=="GET") {
            new MainPageController().getMainPageInfo(req,resp);
        }else if(req.getServletPath()=="/superadmin" && req.getMethod()=="POST"){
            new HeadLineOperationController().addHeadLine(req,resp);
        }
    }
}
