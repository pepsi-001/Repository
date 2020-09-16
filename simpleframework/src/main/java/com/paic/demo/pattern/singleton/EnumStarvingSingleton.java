package com.paic.demo.pattern.singleton;

public class EnumStarvingSingleton {
    private EnumStarvingSingleton(){};
    public static EnumStarvingSingleton getInstance(){
        return ContainerHolder.HOLDER.instance;
    }
    private enum ContainerHolder{
        HOLDER;
        private EnumStarvingSingleton instance;
        private ContainerHolder(){
             instance = new EnumStarvingSingleton();
        }
    }
}
