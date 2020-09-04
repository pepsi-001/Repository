package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/24 15:58
 *
 ****/
public class MyBatisTest {


    public static void main(String[] args)  throws Exception{
        //加载读取MyBatis核心配置文件(SqlMapConfig.xml)
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");

        //创建一个SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //构建一个SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        //获得一个SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取一个AccountMapper接口(Dao层)的代理对象
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        //通过代理对象实现增/删/改/查
        List<Account> accounts = accountMapper.list();

        for (Account account : accounts) {
            System.out.println(account);
        }
        //增删改-->提交事务

        //关闭资源
        is.close();
        sqlSession.close();
    }

}
