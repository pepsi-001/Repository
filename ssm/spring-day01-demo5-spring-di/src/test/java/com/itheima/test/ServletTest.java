package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:30
 *
 ****/
public class ServletTest {


    /***
     * 测试
     *
     * ClassPathXmlApplicationContext:从类路径下加载对应的配置文件
     */
    @Test
    public void testSpringIoc(){
        //创建加载Spring的IOC容器  Map-->beans
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) act.getBean("accountService");
        accountService.save("哈哈哈-！");
    }



}
