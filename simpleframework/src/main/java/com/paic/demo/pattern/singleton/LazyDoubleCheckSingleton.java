package com.paic.demo.pattern.singleton;

public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){
        //第一次检测
        if (instance==null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance==null) {
                    /*volatile使得对象创建按1、2、3步骤执行，如果没有则2、3步骤是无序的，
                    多线程下有可能返回虽然分配了内存而未被初始化的对象【初始化容器时间很长几十秒】给其他线程使用，此时就是天坑，volatile就能避免，让对象创建顺序按照1、2、3步骤在执行*/
                        //memory=allocate();  1.分配对象内存空间
                        //instance(memory);   2.初始化对象
                        //instance=memory;    3.设置instance指向刚分配的内存地址，此时instance！=null
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(LazyDoubleCheckSingleton.getInstance());
        System.out.println(LazyDoubleCheckSingleton.getInstance());
    }
}
