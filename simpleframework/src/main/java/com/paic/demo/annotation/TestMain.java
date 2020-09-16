package com.paic.demo.annotation;

import com.paic.demo.annotation.Person;
import com.paic.demo.annotation.PersonInfoAnnotation;

import java.lang.reflect.Field;

public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<Person> cls = (Class<Person>) Class.forName("com.paic.demo.annotation.Person");
        Field paicDevFiled = cls.getField("paicDev");
        boolean annotationPresentFlag = paicDevFiled.isAnnotationPresent(PersonInfoAnnotation.class);
        if (annotationPresentFlag) {
            PersonInfoAnnotation personInfoAnnotation = paicDevFiled.getAnnotation(PersonInfoAnnotation.class);
            System.out.println(personInfoAnnotation.name()+":"+personInfoAnnotation.age()+":"+personInfoAnnotation.devLanguage()[0]+":"+personInfoAnnotation.devLanguage()[1]+":"+personInfoAnnotation.devLanguage()[2]);
        }
    }
}
