package com.itheima.springmvc.test;

import com.itheima.annotation.RequestMapping;
import com.itheima.controller.UserController;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 14:53
 *
 ****/
public class SpringMVCTest {

    /***
     * 获取注解上对应的属性值
     */
    @Test
    public void testGetAnnotation(){
        //获取类的字节码对象
        Class clazz = UserController.class;

        //获取类上的注解
        RequestMapping typeAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);

        //类上注解的值
        String typeAnnotationName="";
        if(typeAnnotation!=null){
            typeAnnotationName = typeAnnotation.value();
        }

        //获取所有方法
        Method[] methods = clazz.getDeclaredMethods();

        //循环所有方法
        for (Method method : methods) {
            //获取方法上的注解
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);

            if(methodAnnotation!=null){
                //获取注解的值
                String methodAnnotationValue = methodAnnotation.value();
                System.out.println(typeAnnotationName + methodAnnotationValue+"                      "+method.getDeclaringClass().getName()+"."+method.getName());
            }
        }
    }
}
