package cn.itcast.framework.init;

import cn.itcast.framework.annotation.RequestMapping;
import cn.itcast.framework.handler.ServiceHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 解析本地数据
 */
public class LocalParseClass extends ServiceHandler{

    private static String INIT_PACKAGE_PARAMER="scann-package";

    /***
     * 用户存储所有控制层对外提供调用的方法
     */
    private static Map<String,Method> methodMap = new HashMap<String, Method>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //扫描所有需要对外提供访问的类
        String packagename = config.getInitParameter(INIT_PACKAGE_PARAMER);

        //获取指定的包下所有Class
        List<Class<?>> classes = LoadClass.getClasses(packagename);

        //解析所有对应的类，获取上面拥有@RequestMapping注解的类
        for (Class<?> clazz : classes) {
            //获取有RequestMapping注解的类
            RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);

            //如果注解不为空，说明需要解析映射
            if(annotation!=null){
                //先解析类的映射关系
                String parentURI = annotation.value();

                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    //解析方法的映射关系
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    if(methodAnnotation!=null){
                        //方法映射
                        String methodURI = methodAnnotation.value();

                        //完整路径=类映射关系+方法映射关系
                        String uri = parentURI+methodURI;

                        //映射关系以键值对的方式存储到Map中
                        methodMap.put(uri,method);
                    }
                }
            }
        }

        //输出路径
        for (Map.Entry<String, Method> stringMethodEntry : methodMap.entrySet()) {
            String loadMethodPath = stringMethodEntry.getKey()+":"+stringMethodEntry.getValue().getName();
            System.out.println(loadMethodPath);
        }
    }

    /***
     * 根据对应的URI获取Method
     * @param uri
     * @return
     */
    public static Method getMethod(String uri){
        return methodMap.get(uri);
    }
}
