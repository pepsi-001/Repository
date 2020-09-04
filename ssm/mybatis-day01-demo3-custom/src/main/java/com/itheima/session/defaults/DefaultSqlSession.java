package com.itheima.session.defaults;

import com.itheima.session.Configuration;
import com.itheima.session.SqlSession;
import com.itheima.session.mapper.Mapper;
import com.itheima.session.proxy.MapperProxyFactory;
import com.itheima.session.util.Executor;

import java.lang.reflect.*;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 16:45
 *
 ****/
public class DefaultSqlSession implements SqlSession {

    //Configuration->可以操作数据库
    private Configuration cfg;

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    /***
     * 创建Dao接口代理对象
     * @param daoMapperClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoMapperClass) {
        //1.被代理的对象的类加载器
        //2.被代理对象的（实现的）接口
        //3.代码增强---操作数据库  InvocationHandler
        return (T) Proxy.newProxyInstance(
                daoMapperClass.getClassLoader(),    //被代理的对象的类加载器
                new Class[]{daoMapperClass},        //被代理对象的（实现的）接口  UserMapper
                new MapperProxyFactory(this)
        );
    }




    /***
     * 执行查询
     * @param key
     * @param <E>
     * @return
     */
    @Override
    public <E> List<E> selectList(String key){
        //SQL语句+resultType
        Mapper mapper = cfg.getMappers().get(key);

        if(mapper!=null){
            //执行查询
            return Executor.list(cfg.getConnection(),mapper);
        }
        return  null;
    }




    @Override
    public void close() {

    }


    /***
     * 在一个类中实现备份
     * @param daoMapperClass
     * @param <T>
     * @return
     */
    public <T> T getMapperBak(Class<T> daoMapperClass) {
        //1.被代理的对象的类加载器
        //2.被代理对象的（实现的）接口
        //3.代码增强---操作数据库  InvocationHandler
        return (T) Proxy.newProxyInstance(
                daoMapperClass.getClassLoader(),    //被代理的对象的类加载器
                new Class[]{daoMapperClass},        //被代理对象的（实现的）接口  UserMapper
                new InvocationHandler() {
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
                        //正式返回值 List<User> --> List
                        Class<?> returnType = method.getReturnType();

                        //集合查询
                        if(returnType==List.class){
                            return  selectList(key);
                        }else{
                            //增删改查----自己实现
                        }
                        return  null;
                    }
                }
        );
    }
}
