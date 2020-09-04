package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
public class LoggerAround {

    /***
     * 环绕通知
     * @param joinPoint
     * @return
     */
    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("-------before-----");
            result = joinPoint.proceed();
            System.out.println("-------after-----");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }

}
