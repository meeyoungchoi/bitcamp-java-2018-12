package ch28.b;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션 유지범위 지정하기
//=>아무것도 지정하지 않으면 기본이 클래스이다.
//=>또는 다음과 같이 명시적으로 지어할 수 있다.
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {

}
