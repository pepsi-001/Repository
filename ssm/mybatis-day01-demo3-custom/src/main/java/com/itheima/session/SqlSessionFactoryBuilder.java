package com.itheima.session;

import com.itheima.session.defaults.DefaultSqlSession;
import com.itheima.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStream; /***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 16:37
 *
 ****/
public class SqlSessionFactoryBuilder {

    /***
     * 构建一个SqlSessionFactory对象
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is) {
        //创建SqlSessionFactory的实例
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory();

        //将主配置文件的字节输入流赋值给DefaultSqlSessionFactory
        defaultSqlSessionFactory.setIs(is);

        return  defaultSqlSessionFactory;
    }
}
