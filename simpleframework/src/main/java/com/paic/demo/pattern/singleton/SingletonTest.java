package com.paic.demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //test1();
        //test2();
        EnumSingleton instance = EnumSingleton.INSTANCE;
    }

    private static void test2() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println(EnumStarvingSingleton.getInstance());
        Class clazz = EnumStarvingSingleton.class;
        Constructor<EnumStarvingSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = constructor.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());
    }

    private static void test1() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //单例模式真的安全嘛？反射暴力破解
        Class<StarvingSingleton> singletonClass = StarvingSingleton.class;
        Constructor<StarvingSingleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        StarvingSingleton starvingSingleton = declaredConstructor.newInstance();
        System.out.println(starvingSingleton);
    }
}
