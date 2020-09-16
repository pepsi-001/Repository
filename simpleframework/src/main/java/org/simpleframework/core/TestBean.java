package org.simpleframework.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestBean {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<BeanContainer> clazz = BeanContainer.class;
        Constructor<BeanContainer> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BeanContainer bean1 = constructor.newInstance();
        BeanContainer bean2 = constructor.newInstance();
        System.out.println(bean1);
        System.out.println(bean2);
    }
}
