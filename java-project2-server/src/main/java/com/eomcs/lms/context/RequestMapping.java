package com.eomcs.lms.context;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//이거를 안하면 실행할 때 메모리에 안올라와서 꺼낼수가 없다.
public @interface RequestMapping {
	String value() default "";
}
