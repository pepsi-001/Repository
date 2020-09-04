package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/9 15:39
 *
 ****/
public class MyBatisTest {


    private UserMapper userMapper;

    private SqlSession sqlSession;

    /***
     * 初始化应用
     * @throws Exception
     */
    @Before
    public void init() throws Exception{//读取核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建会话工厂对象的构建对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        /***
         * 会话工厂对象的创建
         * builder.build(is):
         *          构建者模式:隐藏了对象创建的流程，让用户无需关心对象是如何创建的。
         */
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        //SqlSession
        sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);

        //关闭资源
        is.close();
    }


    /****
     * 根据ID查询
     */
    @Test
    public void testGetByUserId(){
        int id=7;
        //根据ID查询
        User user = userMapper.getByUserId(id);

        System.out.println(user);
    }


    /***
     * 根据名字模糊查询
     */
    @Test
    public void testGetByUserName(){
        List<User> users = userMapper.getByUserName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }


    /***
     * 增加操作
     */
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("小猪");
        user.setAddress("深圳");
        user.setSex("女");
        user.setBirthday(new Date());

        //增加用户
        userMapper.addUser(user);

        System.out.println(user);
    }
    /***
     * returnType
     */
    @Test
    public void testReturnType() throws NoSuchMethodException {
        Class<UserMapper> mapperClass = UserMapper.class;
        //User getByUserId(Integer id);
        //List<User> getByUserName(String username);
        Method methodGetByUserId = mapperClass.getMethod("getByUserId",Integer.class);
        Method methodGetByUserName = mapperClass.getMethod("getByUserName",String.class);
        //返回值 List<User> --> User
        //返回Type表示由此所表示的方法的正式返回类型的对象Method的对象。
        //如果返回类型是参数化的类型，所述Type返回必须准确地反映源代码中使用的实际类型参数的对象
        Class<?> returnType1 = methodGetByUserId.getReturnType();
        Type genericReturnType1 = methodGetByUserId.getGenericReturnType();
        Class<?> returnType2 = methodGetByUserName.getReturnType();
        Type genericReturnType2 = methodGetByUserName.getGenericReturnType();
        String GenericResultType1 = null;
        String GenericResultType2 = null;
        //判断当前类型是否为参数化类型
        if(genericReturnType1 instanceof ParameterizedType){//false
            //强转成参数类型
            ParameterizedType ptype1 = (ParameterizedType) genericReturnType1;

            //获得实际参数类型
            Type[] actualTypeArguments1 = ptype1.getActualTypeArguments();

            //获取第1个实际参数类型
            Class domainClass1 = (Class) actualTypeArguments1[0];

            //获取返回类型
            GenericResultType1 = domainClass1.getName();
        }
        if(genericReturnType2 instanceof ParameterizedType){
            //强转成参数类型
            ParameterizedType ptype2 = (ParameterizedType) genericReturnType2;

            //获得实际参数类型
            Type[] actualTypeArguments2 = ptype2.getActualTypeArguments();

            //获取第1个实际参数类型
            Class domainClass2 = (Class) actualTypeArguments2[0];

            //获取返回类型
            GenericResultType2 = domainClass2.getName();
        }
        System.out.println(returnType1);//class com.itheima.domain.User
        System.out.println(GenericResultType1);//null
        System.out.println(returnType2);//interface java.util.List
        System.out.println(GenericResultType2);//com.itheima.domain.User
    }

    /***
     * 关闭资源
     */
    @After
    public void destroy(){
        //提交事物
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }







}
