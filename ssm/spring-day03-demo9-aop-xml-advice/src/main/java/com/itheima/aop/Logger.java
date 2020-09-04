package com.itheima.aop;

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
        System.out.println("----------afterReturning----------");
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
}
