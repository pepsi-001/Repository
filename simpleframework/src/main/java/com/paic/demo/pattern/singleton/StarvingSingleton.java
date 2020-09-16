package com.paic.demo.pattern.singleton;

import java.lang.reflect.InvocationTargetException;

/**
 * 单例 饿汉式
 */
public class StarvingSingleton {
    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();
    private StarvingSingleton(){};
    public static StarvingSingleton getInstance(){
        return starvingSingleton;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(StarvingSingleton.getInstance());
    }
}
