package com.paic;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
@Slf4j
public class HelloServlet extends HttpServlet {
    //Logger log = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    public void init() throws ServletException {
        System.out.println("init....");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是程序入口，我执行doget（）。。。");
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("logger:我的简易框架");
        String name = "我的简易框架";
        req.setAttribute("name",name);
        req.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
