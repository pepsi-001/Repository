package com.itheima.framework;

import com.itheima.annotation.RequestMapping;
import com.itheima.controller.CatController;
import com.itheima.controller.UserController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 * @Author:shenkunlin
 * @Description:itheima
 * @date: 2018/10/21 15:04
 *
 ****/
public class DispacherServlet extends HttpServlet{


    //存储对应的映射关系
    public static Map<String,Method> handlers = new HashMap<String,Method>();

    /***
     * 重写Service方法，拦截用户请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户的uri
        String uri = req.getRequestURI();

        //使用HandlderMapping获取对应的Handler(对应的方法)
        Method method = handlerMapping(uri);

        //执行调用
        Object result = handlAdapter(method);

        if(result!=null && !"".equals(result.toString().trim())){
            //视图解析
            viewResolver(result.toString(),req,resp);
        }else{
            super.service(req,resp);
        }

    }

    /***
     * 视图解析处理
     * [图片输出][excel解析][world解析][直接输出json字符]....
     * @param viewName
     * @param request
     * @param response
     */
    public void viewResolver(String viewName,HttpServletRequest request,HttpServletResponse response){
        try {
            //转发
            request.getRequestDispatcher(viewName).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /***
     * 执行方法调用
     * 方法参数处理等
     * @param method
     * @return
     */
    public Object handlAdapter(Method method){
        try {
            //处理对应方法所需参数
            //...类型转换

            //获取对应类的实例   初始化一次存入到容器中
            Object instance = method.getDeclaringClass().newInstance();

            //反射调用   基本数据类型-string类型(借助第三方工具，让编译的代码的方法带有参数名字)|User->继续解析User>从前台获取数据，反射赋值
            Object result = method.invoke(instance, null);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /***
     * 获取对应的方法
     * @param uri
     * @return
     */
    public Method handlerMapping(String uri){
        return handlers.get(uri);
    }


    /***
     * 初始化方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

        List<Class> clazzes = new ArrayList<Class>();
        clazzes.add(UserController.class);
        clazzes.add(CatController.class);

        for (Class clazz : clazzes) {
            //获取类的字节码对象
            //Class clazz = UserController.class;

            //获取类上的注解
            RequestMapping typeAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);

            //类上注解的值
            String typeAnnotationName="";
            if(typeAnnotation!=null){
                typeAnnotationName = typeAnnotation.value();
            }

            //获取所有方法
            Method[] methods = clazz.getDeclaredMethods();

            //循环所有方法
            for (Method method : methods) {
                //获取方法上的注解
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);

                if(methodAnnotation!=null){
                    //获取注解的值
                    String methodAnnotationValue = methodAnnotation.value();
                    System.out.println(typeAnnotationName + methodAnnotationValue+"                      "+method.getDeclaringClass().getName()+"."+method.getName());
                    //将映射数据存入到Map中
                    handlers.put(typeAnnotationName + methodAnnotationValue,method);
                }
            }
        }

    }
}
