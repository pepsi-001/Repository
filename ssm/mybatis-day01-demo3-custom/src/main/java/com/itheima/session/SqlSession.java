package com.itheima.session;

import com.itheima.mapper.UserMapper;

import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 16:38
 *
 ****/
public interface SqlSession {

    <E> List<E> selectList(String key);

    <T> T getMapper(Class<T> daoMapperClass);

    void close();
}
