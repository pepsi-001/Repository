package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取包下类集合
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extractPackageClass(String packageName) throws IOException {
        //1.获取类加载器
        ClassLoader classLoader = getClassLoader();
        //2.通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".","/"));//getResource /的资源路径
        /*Enumeration<URL> dirs = classLoader.getResources(packageName.replace(".", "/"));//getResource /的资源路径
        while (dirs.hasMoreElements()) {
            URL elementURL = dirs.nextElement();
            if (elementURL.getProtocol().equalsIgnoreCase("file")) {
                String file = elementURL.getFile();
                System.out.println(file);
            }
        }*/
        if (url==null) {
            log.warn("unable to retrieve anything form package:"+packageName);
            return null;
        }
        //3.依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File packageDirecotry = new File(url.getPath());
            extractClassFile(classSet,packageDirecotry,packageName);
        }
        return null;
    }

    private static void extractClassFile(Set<Class<?>> classSet, File packageDirecotry, String packageName) {

    }

    /**
     * 获取classloader
     * @return 当前classloader
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) throws IOException {
        extractPackageClass("com.paic.entity");
    }
}
