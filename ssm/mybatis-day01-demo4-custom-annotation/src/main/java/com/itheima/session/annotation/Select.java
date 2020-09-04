package com.itheima.session.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 18:27
 *
 ****/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {

    //记录SQL语句
    String value() default "";
}
