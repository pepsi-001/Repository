package com.itheima.session;

import com.itheima.io.Resources;
import com.itheima.session.mapper.Mapper;
import com.itheima.session.util.AnnotationMapperParse;
import com.sun.org.apache.regexp.internal.RE;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 16:50
 *       用于解析SqlMapConfig.xml文件
 ****/
public class XMLConfigBuilder {

    /***
     * 解析主配置文件
     * @param is  :主配置文件(SqlMapConfig.xml)的字节输入流
     */
    public static Configuration loadSqlMapConfig(InputStream is) {
        //创建Configuration对象
        Configuration cfg = new Configuration();

        try {
            //创建SAXReader
            SAXReader reader = new SAXReader();

            //加载文件字节输入流读取出一个文档对象
            Document document = reader.read(is);

            //获取数据库连接信息
            List<Element> propertyList = document.selectNodes("//property");//搜索所有property节点信息

            //循环所有节点
            for (Element element : propertyList) {
                //获取每个节点的name属性值和value属性值
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                //给Configuration对象赋值
                if (name.equals("driver")) {
                    cfg.setDriver(value);
                } else if (name.equals("url")) {
                    cfg.setUrl(value);
                } else if (name.equals("username")) {
                    cfg.setUsername(value);
                } else if (name.equals("password")) {
                    cfg.setPassword(value);
                }
            }


            //获取mapper中的resource属性值-获取需要解析的XML文件
            List<Element> mapperList = document.selectNodes("//mapper");

            //遍历循环解析每个mapper节点，解析对应的Mapper.xml
            for (Element element : mapperList) {
                //获取解析文件路径
                //String resource = element.attributeValue("resource");

                //获取resource属性
                Attribute attributeResource = element.attribute("resource");

                //XML解析
                if(attributeResource!=null){
                    //获取resources的属性值
                    String resource = attributeResource.getValue();
                    //解析Mapper.xml文件
                    Map<String,Mapper> mappers = loadXmlMapper(resource);

                    cfg.setMappers(mappers);
                }else{
                    //注解解析
                    String daoClass = element.attributeValue("class");

                    //解析注解配置获取Mapper集合信息
                    Map<String, Mapper> mappers = AnnotationMapperParse.loadAnnotationMapper(Class.forName(daoClass));

                    //将解析的Mapper信息给Configuration
                    cfg.setMappers(mappers);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cfg;
    }

    /***
     * 解析Mapper.xml文件(UserMapper.xml)
     * @param resource
     */
    public static Map<String,Mapper> loadXmlMapper(String resource) {
        //定义一个Map存储SQL语句和返回的结果集对象全限定名
        Map<String,Mapper> mappers = new HashMap<String,Mapper>();

        try {
            //获取文件的字节输入流
            InputStream is = Resources.getResourceAsStream(resource);

            //创建SAXReader
            SAXReader reader = new SAXReader();

            //读取文件字节输入流构建一个文档对象
            Document document = reader.read(is);

            //获取namespece
            Element rootElement = document.getRootElement();
            String namespace = rootElement.attributeValue("namespace");

            System.out.println("namespace:"+namespace);

            //获取select节点（集合）
            List<Element> selectList = document.selectNodes("//select");

            //循环select节点
            for (Element element : selectList) {
                //获取id属性
                String id = element.attributeValue("id");
                System.out.println("id:"+id);

                //获取resultType
                String resultType = element.attributeValue("resultType");
                //获取SQL语句
                String sql = element.getText().trim();

                //封装一个Mapper
                //key=namespace+.+id
                //namespace=接口的全限定名 = 被调用方法所在类的全限定名
                //id=接口中的方法名        = 被调用的方法名
                mappers.put(namespace+"."+id,new Mapper(sql,resultType));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mappers;
    }


}
