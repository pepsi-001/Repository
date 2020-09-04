package com.itheima.annotation;

import java.lang.annotation.*;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 14:45
 *
 ****/
@Target(value = {ElementType.METHOD,ElementType.TYPE})  //注解使用的范围
@Retention(RetentionPolicy.RUNTIME)                     //生命周期(什么时候注解生效)
public @interface RequestMapping {

    //定义value属性,默认值是""
    String value() default "";

    //定义一个method属性
    String method() default "";
}
