package com.paic.demo.annotation;

import com.paic.demo.annotation.PersonInfoAnnotation;

public class Person {
    @PersonInfoAnnotation(name="张三丰",age=18,devLanguage={"java","python","php"})
    public String paicDev;
}
