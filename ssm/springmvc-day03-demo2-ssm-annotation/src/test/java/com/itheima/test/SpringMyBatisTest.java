package com.itheima.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 16:23
 *
 ****/
public class SpringMyBatisTest {

    public static void main(String[] args) {
        //创建Spring容器
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");

        //Spring容器中会有的所有Bean的Id
        String[] names = act.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println(name);
        }

    }
}
