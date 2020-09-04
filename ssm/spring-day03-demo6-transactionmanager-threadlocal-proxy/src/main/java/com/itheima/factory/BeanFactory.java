package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.util.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/18 16:56
 *  给指定对象创建代理
 ****/
public class BeanFactory {

    //注入事务管理器
    private TransactionManager txtManager;


    //注入AccountService实例
    private AccountService accountService;

    /****
     * 工程对象创建一个代理
     * @return
     */
    public AccountService createAccountService(){
        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(
                AccountService.class.getClassLoader(),
                new Class[]{AccountService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {

                            //开启事务
                            txtManager.beginTransaction();

                            //真实方法被调用
                            result = method.invoke(accountService, args);


                            //只读
                            if(!method.getName().startsWith("query") || !method.getName().startsWith("get")){
                                //提交事务
                                txtManager.commit();
                            }
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();

                            //事务回滚
                            txtManager.rollback();
                        }finally {
                            //关闭资源
                            txtManager.close();
                        }
                        return result;
                    }
                }
        );
        return  accountServiceProxy;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxtManager(TransactionManager txtManager) {
        this.txtManager = txtManager;
    }
}
