package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/17 15:30
 *
 ****/
@Component(value = "accountService")
@Scope("singleton") //prototype | singleton
public class AccountServiceImpl implements AccountService {
    /****
     * 注入Dao
     * @Autowired
     * 装配方式:
     *      默认装配：根据类型进行装配
     *      如果存在多个匹配上的Bean的实例,此时会根据名字进行装配
     *      如果名字找不到相同的对象,则报错
     *
     *      支持泛型注入
     *
     *
     * @Resource
     *      注入
     *      默认装配方式：根据名字进行装配
     *      如果名字装配失败,则根据类型进行装配
     *      如果类型装配失败，则报错
     *
     *
     * @Value("给一个String或者基本数据类型注入值【一般是将配置文件中的数据注入进来】")
     * */
    @Autowired
    @Qualifier(value = "accountDao")    //在方法中可以独立使用
    private AccountDao accountDaoImpl;

    @Value("小红")
    private String username;

    @Override
    public void addAccount(Account account) {
        accountDaoImpl.addAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDaoImpl.updateAccount(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountDaoImpl.deleteAccount(id);
    }

    @Override
    public Account getById(int id) {
        return accountDaoImpl.getById(id);
    }

    @Override
    public List<Account> list() {
        System.out.println(username);
        return accountDaoImpl.list();
    }

    @PostConstruct
    public void init(){
        System.out.println("对象创建了！");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("对象想销毁了！");
    }

}
