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
     * new 一个对象
     *
     * 存在硬编码
     */
    private AccountService accountService;

    /***
     * 测试
     *
     * ClassPathXmlApplicationContext:从类路径下加载对应的配置文件
     */
    @Test
    public void testSpringIoc(){
        //创建加载Spring的IOC容器  Map-->beans
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");

        //从容器中获取对象的实例
        AccountService accountService = (AccountService) act.getBean("accountService");
        accountService.save("小黑");

        //获取AccountDao的实例
        AccountDao accountDao = (AccountDao) act.getBean("accountDao");
        accountDao.save("小红");
    }


    /***
     * FileSystemXmlApplicationContext
     */
    @Test
    public void testFileSystemXmlApplicationContext(){
        //创建加载Spring的IOC容器  Map-->beans
        ApplicationContext act = new FileSystemXmlApplicationContext("D:/beans.xml");

        //从容器中获取对象的实例
        AccountService accountService = (AccountService) act.getBean("accountService");
        accountService.save("小黑");

        //获取AccountDao的实例
        AccountDao accountDao = (AccountDao) act.getBean("accountDao");
        accountDao.save("小红");
    }


    /***
     * ApplicationContext:
     *      应用加载，容器加载的时候立刻创建对象的实例
     *      创建对象实例：实例默认都是单利模式
     *
     * BeanFactory:
     *      什么时候使用对象，什么时候创建对象实例
     *      创建对象实例：实例默认都是单利模式
     */
    @Test
    public void testApplicationContext(){
        //创建加载Spring的IOC容器  Map-->beans
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService1 = (AccountService) act.getBean("accountService");
        AccountService accountService2 = (AccountService) act.getBean("accountService");

        System.out.println(accountService1 == accountService2);
    }

    /***
     * 测试BeanFactory
     */
    @Test
    public void testBeanFactory(){
        //创建一个Resource
        Resource resource = new ClassPathResource("beans.xml");

        //创建BeanFactory的实例   BeanFactory:Spring IOC容器
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println("========加载Spring的BeanFactory容器完毕===========");
        System.out.println("========开始使用对象的实例===========");
        //使用AccountService的实例
        AccountService accountService1 = (AccountService) beanFactory.getBean("accountService");
        AccountService accountService2 = (AccountService) beanFactory.getBean("accountService");

        System.out.println(accountService1 == accountService2);
    }


    /****
     * 作用范围
     */
    @Test
    public void testScope(){
        //创建加载Spring的IOC容器  Map-->beans
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService1 = (AccountService) act.getBean("accountService");
        AccountService accountService2 = (AccountService) act.getBean("accountService");

        //销毁
        System.out.println(accountService1 == accountService2);
    }




    /****
     * 生命周期
     *      单利模式的生命周期:
     *          对象创建：应用加载，容器创建，对象会立刻创建
     *          对象存活：容器如果存在，则对象一直存活(存在IOC容器中)
     *          对象销毁：容器销毁，对象销毁
     */
    @Test
    public void testSingletonInitDestroy(){
        //创建加载Spring的IOC容器  Map-->beans
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService1 = (AccountService) act.getBean("accountService");
        act.close();
        accountService1.save("小何小牛");
    }


    /****
     * 生命周期
     *      多利模式的生命周期:
     *          对象创建：应用加载，容器创建,当使用对象时对象才创建
     *          对象存活：如果在使用对象，则对象存活
     *          对象销毁：由Java回收器回收
     */
    @Test
    public void testPrototypeInitDestroy(){
        //创建加载Spring的IOC容器  Map-->beans
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService1 = (AccountService) act.getBean("accountService");
        act.close();
        accountService1.save("小何小牛");
    }


    /****
     * 单利数据安全测试
     */
    @Test
    public void testSingletonData(){
        //创建加载Spring的IOC容器  Map-->beans
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");

        //发工资
        AccountService accountService = (AccountService) act.getBean("accountService");
        accountService.payMoney("小红",999);

        //李四发工资
        AccountService accountService1 = (AccountService) act.getBean("accountService");
        accountService1.payMoney("李四",999);

    }
}
