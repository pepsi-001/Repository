package com.itheima;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 18:46
 *
 ****/
@Configuration
@ComponentScan(basePackages = "com")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
