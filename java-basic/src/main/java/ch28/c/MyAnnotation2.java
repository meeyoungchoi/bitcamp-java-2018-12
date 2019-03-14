package ch28.c;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 애노테이션 유지범위 지정하기
//
@Target(ElementType.FIELD)//필드선언에 붙일수 있다.
public @interface MyAnnotation2 {

}
