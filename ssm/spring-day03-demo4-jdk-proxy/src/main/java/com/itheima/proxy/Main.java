package com.itheima.proxy;

import com.itheima.service.SaleService;
import com.itheima.service.impl.SaleServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 16:10
 *
 ****/
public class Main {

    public static void main(String[] args) throws Exception{
        SaleService saleService = new SaleServiceImpl();
        saleService.saleProduct(999f*0.75f);
        saleService.afterService(999f*0.5f);

        System.out.println("==============================");

        /***
         * JDK动态代理
         *  1)类加载器,让当前产生代理对象和被代理的对象拥有相同的类加载器[固定写法]
         *  2)被代理对象实现的 接口 或者被代理的 接口
         *        目的：让生成代理对象和被代理的接口拥有相同的行为动作
         *  3)InvocationHandler的实现：代码增强实现，在这里通常用于处理一些相同的或者频繁出现的业务逻辑代码
         *                             比如：开启事务
         *                                   关闭事务
         *                                   提交事务
         *                                   关闭资源
         */
        SaleService proxySaleService = (SaleService) Proxy.newProxyInstance(
                SaleServiceImpl.class.getClassLoader(),
                SaleServiceImpl.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //args
                        Float money = (Float) args[0];

                        //目标方法调用
                        //1)对象的实例
                        Object result = null;

                        if(method.getName().equals("saleProduct")){
                            result = method.invoke(saleService,money*0.75f);
                        }else if(method.getName().equals("afterService")){
                            result = method.invoke(saleService,money*0.5f);
                        }
                        return result;
                    }
                }
        );


        proxySaleService.saleProduct(999f);
        proxySaleService.afterService(999f);

        byte[] proxyClass = ProxyGenerator.generateProxyClass(proxySaleService.getClass().getSimpleName(), proxySaleService.getClass().getInterfaces());
        //将字节码文件保存到D盘，文件名为$Proxy0.class
        FileOutputStream outputStream = new FileOutputStream(new File("d:\\$Proxy0.class"));
        outputStream.write(proxyClass);
        outputStream.flush();
        outputStream.close();
    }
}
