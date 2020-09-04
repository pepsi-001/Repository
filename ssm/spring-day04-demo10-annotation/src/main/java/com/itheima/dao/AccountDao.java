package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/20 15:37
 *
 ****/
public interface AccountDao {

    /***
     * 查询所有
     * @return
     */
    List<Account> list();

    /***
     * 根据名字查询
     * @param name  假设名字唯一
     * @return
     */
    Account getByName(String name);

    /***
     * 修改操作
     * @param account
     * @return
     */
    int updateById(Account account);

    List<String> getAllName();

    int getCount();

    Account getAccountById(Integer id);
}
