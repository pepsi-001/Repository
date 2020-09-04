package com.itheima.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 17:27
 *
 ****/
//@Component(value = "logger")
//@Aspect
public class Logger {

    /****
     * 前置通知方法
     */
    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void printLog(){
        System.out.println("------------before--------");
    }

    /***
     * 后置通知
     * after-returning
     */
    @AfterReturning("execution(* com.itheima.service.impl.*.*(..))")
    public void afterLog(){
        System.out.println("----------afterReturning----------");
    }

    /***
     * after-throwing
     * 异常通知
     */
    @AfterThrowing("execution(* com.itheima.service.impl.*.*(..))")
    public void error(){
        System.out.println("--------after-throwing--------");
    }

    /***
     * after
     * 最终通知
     */
    @After("execution(* com.itheima.service.impl.*.*(..))")
    public void after(){
        System.out.println("---------after----------");
    }
}
