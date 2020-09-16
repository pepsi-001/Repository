package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {
    public static BeanContainer getInstance(){
        return ContainerHolder.INSTANCE.instance;
    }
    private enum ContainerHolder{
        INSTANCE;
        private BeanContainer instance;
        ContainerHolder() {
            instance = new BeanContainer();
        }
    }
}
