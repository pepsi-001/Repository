package com.paic.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value ={ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
public @interface PersonInfoAnnotation {
    String name() default "xiaohong";
    int age() default 28;
    String[] devLanguage();
}
