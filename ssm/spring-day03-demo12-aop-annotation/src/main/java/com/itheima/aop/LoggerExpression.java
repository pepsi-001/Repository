package com.itheima.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 17:27
 *
 ****/
@Component(value = "logger")
@Aspect
public class LoggerExpression {

    //切入点表达式配置
    @Pointcut(value = "execution(* com.itheima.service.impl.*.*(..))")
    public void aopPointcut(){
    }

    /****
     * 前置通知方法
     */
    @Before("aopPointcut()")
    public void printLog(){
        System.out.println("------------before--------");
    }

    /***
     * 后置通知
     * after-returning
     */
    @AfterReturning("aopPointcut()")
    public void afterLog(){
        System.out.println("----------afterReturning----------");
    }

    /***
     * after-throwing
     * 异常通知
     */
    @AfterThrowing("aopPointcut()")
    public void error(){
        System.out.println("--------after-throwing--------");
    }

    /***
     * after
     * 最终通知
     */
    @After("aopPointcut()")
    public void after(){
        System.out.println("---------after----------");
    }
}
