package com.itheima.proxy;

import com.itheima.service.SaleService;
import com.itheima.service.impl.SaleServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
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
        SaleServiceImpl saleService = new SaleServiceImpl();
        saleService.saleProduct(999f*0.75f);
        saleService.afterService(999f*0.5f);

        /***
         * CGLib动态代理
         */
        SaleServiceImpl proxySaleServiceImpl = (SaleServiceImpl) Enhancer.create(SaleServiceImpl.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                //args
                Float money = (Float) args[0];

                //目标方法调用
                //1)对象的实例
                Object result = null;

                //开启事物
                try {
                    if(method.getName().equals("saleProduct")){

                        result = method.invoke(saleService,money*0.75f);

                    }else if(method.getName().equals("afterService")){
                        result = method.invoke(saleService,money*0.5f);
                    }

                    //提交事物
                } catch (Exception e) {
                    e.printStackTrace();
                    //回滚
                }finally {
                    //关闭资源
                }
                return result;
            }
        });

        proxySaleServiceImpl.saleProduct(999f);
        proxySaleServiceImpl.afterService(999f);

    }
}
