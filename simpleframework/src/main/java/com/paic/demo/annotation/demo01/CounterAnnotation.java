package com.paic.demo.annotation.demo01;

import java.lang.annotation.Annotation;

public interface CounterAnnotation extends Annotation {

	int count();
}