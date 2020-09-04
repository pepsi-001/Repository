package com.itheima.io;

import java.io.InputStream;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 16:36
 *
 ****/
public class Resources {

    /***
     * 读取类路径下的文件
     * @param path  指定的是类路径下的文件路径
     * @return
     */
    public static InputStream getResourceAsStream(String path) {
        //获取类加载器
        ClassLoader classLoader = Resources.class.getClassLoader();

        //读取了类路径下的文件
        return  classLoader.getResourceAsStream(path);
    }
}
