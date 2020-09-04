package com.itheima.session.defaults;

import com.itheima.session.Configuration;
import com.itheima.session.SqlSession;
import com.itheima.session.SqlSessionFactory;
import com.itheima.session.XMLConfigBuilder;

import java.io.InputStream;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 16:44
 *
 ****/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    //核心配置文件的字节输入流
    private InputStream is;
    public void setIs(InputStream is) {
        this.is = is;
    }

    /****
     * 创建一个SqlSession会话(Connection)对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        //创建一个DefaultSqlSession
        DefaultSqlSession defaultSqlSession = new DefaultSqlSession();

        //暂时在这里儿调用
        Configuration configuration = XMLConfigBuilder.loadSqlMapConfig(is);

        //将Configuration对象给DefaultSqlSession
        defaultSqlSession.setCfg(configuration);

        return defaultSqlSession;
    }
}
