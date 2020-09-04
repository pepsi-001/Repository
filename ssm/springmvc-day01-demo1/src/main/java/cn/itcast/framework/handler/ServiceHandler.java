package cn.itcast.framework.handler;

import cn.itcast.framework.init.LocalParseClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceHandler extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /***
         * 1、获取请求路径
         * 2、请求参数
         */
        String uri = request.getRequestURI();
        uri = uri.substring(0,uri.lastIndexOf(".shtml"));

        //获取当前请求的路径地址
        Method method = LocalParseClass.getMethod(uri);
        if(method!=null){
            //调用方法
            try {
                //如果返回结果不为空，则直接转发到对应的JSP页面
                HandlerAdapter.invokeMethod(request,response,method);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

