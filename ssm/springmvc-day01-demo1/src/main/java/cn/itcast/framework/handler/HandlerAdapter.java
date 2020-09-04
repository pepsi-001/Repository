package cn.itcast.framework.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/***
 * 调用真实Controller方法
 */
public class HandlerAdapter {

    /***
     * 执行真实调用
     * @param request
     * @param response
     * @param method
     */
    public static void invokeMethod(HttpServletRequest request, HttpServletResponse response, Method method){
        try {
            Object result = method.invoke(method.getDeclaringClass().newInstance(), null);
            if(result!=null){
                //转发----视图解析器
                request.getRequestDispatcher("/WEB-INF/jsp/"+result.toString()+".jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
