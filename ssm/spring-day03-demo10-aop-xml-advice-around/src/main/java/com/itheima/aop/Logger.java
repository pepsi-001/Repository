package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 17:27
 *
 ****/
public class Logger {

    /****
     * 前置通知方法
     */
    public void printLog(){
        System.out.println("------------before--------");
    }

    /***
     * 后置通知
     * after-returning
     */
    public void afterLog(){
        System.out.println("----------afterLog----------");
    }

    /***
     * after-throwing
     * 异常通知
     */
    public void error(){
        System.out.println("--------after-throwing--------");
    }

    /***
     * after
     * 最终通知
     */
    public void after(){
        System.out.println("---------after----------");
    }


    /***
     * around
     * 环绕通知
     */
    public Object around(ProceedingJoinPoint joinPoint){
        Object result = null;
        System.out.println("---------around-----before-----");

        //获取方法参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("---AOP中输出："+arg);
        }

        try {
            //执行目标方法
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //记录日志
            System.out.println("发生异常了兄弟.....");
        }

        System.out.println("---------around-----after-----");

        return result;
    }
}
