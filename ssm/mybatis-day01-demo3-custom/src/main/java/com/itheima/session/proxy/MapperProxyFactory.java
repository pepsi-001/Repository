package com.itheima.session.proxy;

import com.itheima.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 18:18
 *
 ****/
public class MapperProxyFactory implements InvocationHandler {

    //调用SqlSession中的方法
    private SqlSession sqlSession;

    //给SqlSession赋值
    public MapperProxyFactory(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //key=namespace+.+id
        //namespace=接口的全限定名 = 被调用方法所在类的全限定名
        String namespace= method.getDeclaringClass().getName();

        //id=接口中的方法名        = 被调用的方法名
        String methodName = method.getName();

        //组装一个key
        String key = namespace+"."+methodName;

        //获取方法返回类型
        Class<?> returnType = method.getReturnType();
        //集合查询
        if(returnType==List.class){
            return sqlSession.selectList(key);
        }else{
            //增删改查----自己实现
        }
        return  null;
    }
}
