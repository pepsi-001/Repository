package com.itheima.factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/16 13:32
 *
 ****/
public class BeanFactory {
    /****
     * 解耦：
     *      new T
     *      Factory.getT
     *
     * 对象的实例中存在创建新对象的方法，即可称之为工程对象
     *  1)静态工厂      创建新对象的方法为静态方法
     *  2)普通工厂      创建新对象的方法为非静态方法
     */



    //创建一个Properties文件，用于读取beans.properties中的配置信息
    private static Properties properties = new Properties();

    //创建一个全局的Map，用于存储所有对象的实例   容器(IOC)
    private  static Map<String,Object> beans = new HashMap<String,Object>();

    static {
        try {
            //用类加载器读取类路径下的beans.properties
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");

            //将配置文件信息加载到Properties中
            properties.load(is);

            for (Object key : properties.keySet()) {
                System.out.println(key);
                //读取配置文件中所有类的全限定名
                String clazzPaht = (String) properties.get(key.toString());

                //给每个类的全限定名创建一个实例
                Object instance = Class.forName(clazzPaht).newInstance();

                //将实例存储到一个全局的Map中
                beans.put(key.toString(),instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /***
     * 根据对应类的全限定名创建对象的实例
     * @param key     key(入参为配置文件中的key)=com.mysql.jdbc.Driver
     * @param <T>
     * @return
     */
    public static <T> T getBean(String key){
        try {
            //不再创建对象的实例，直接从Map中取出来
            Object instance = beans.get(key);
            return (T) instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /***
     * 根据对应类的全限定名创建对象的实例
     * @param key     key(入参为配置文件中的key)=com.mysql.jdbc.Driver
     * @param <T>
     * @return
     */
    public static <T> T getBeanBak1(String key){
        try {
            //创建对象的实例
            return (T) Class.forName(properties.get(key).toString()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }





    /***
     * 根据对应类的全限定名创建对象的实例
     * @param clazzPath     com.mysql.jdbc.Driver
     * @param <T>
     * @return
     */
    public static <T> T getBeanBak(String clazzPath){
        try {
            //创建对象的实例
            return (T) Class.forName(clazzPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
