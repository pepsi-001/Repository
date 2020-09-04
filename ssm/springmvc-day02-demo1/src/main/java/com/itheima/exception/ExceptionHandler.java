package com.itheima.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/23 18:03
 *
 ****/
public class ExceptionHandler implements HandlerExceptionResolver {

    //异常对象
    Logger logger = Logger.getLogger(ExceptionHandler.class);

    /***
     * 全局异常处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,     //当前调用的对象
            Exception ex        //捕获到的异常信息
    ) {
        //获取异常信息
        //ex.printStackTrace();
        StringWriter stringWriter = new StringWriter();

        //将异常信息由控制台输出转换到StringWriter中
        ex.printStackTrace(new PrintWriter(stringWriter));

        //将异常信息转成字符类型数据
        String errorinfo = stringWriter.toString();




        //直接将异常信息记录日志
        logger.info("发生异常了",ex);




        //创建ModelAndView，设置响应信息
        ModelAndView modelAndView = new ModelAndView();

        //友好提示信息
        modelAndView.addObject("msg","对不起，你的网络不稳定！");
        //设置视图页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
