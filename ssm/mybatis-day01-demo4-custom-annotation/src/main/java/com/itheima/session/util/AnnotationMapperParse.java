package com.itheima.session.util;

import com.itheima.session.annotation.Select;
import com.itheima.session.mapper.Mapper;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 14:19
 *
 ****/
public class AnnotationMapperParse {

    /***
     * 加载解析注解信息
     * @param daoClass
     * @return
     */
    public static Map<String,Mapper> loadAnnotationMapper(Class daoClass) {
        //存储所有方法的Mapper
        Map<String,Mapper> mappers = new HashMap<String,Mapper>();

        //获取所有方法
        Method[] methods = daoClass.getDeclaredMethods();

        //循环所有方法
        for (Method method : methods) {
            //获取方法上的注解
            Select annotation = method.getAnnotation(Select.class);

            if(annotation!=null){
                //获取方法的返回类型
                Type genericReturnType = method.getGenericReturnType();

                //判断当前类型是否为参数化类型
                if(genericReturnType instanceof ParameterizedType){
                    //强转成参数类型
                    ParameterizedType ptype = (ParameterizedType) genericReturnType;

                    //获得实际参数类型
                    Type[] actualTypeArguments = ptype.getActualTypeArguments();

                    //获取第1个实际参数类型
                    Class domainClass = (Class) actualTypeArguments[0];

                    //获取返回类型
                    String resultType = domainClass.getName();

                    //获取SQL语句
                    String sql = annotation.value();

                    //构建一个Mapper
                    Mapper mapper = new Mapper(sql,resultType);

                    //将Mapper存入到Map中
                    mappers.put(method.getDeclaringClass().getName()+"."+method.getName(),mapper);
                }
            }
        }
        return  mappers;
    }
}
