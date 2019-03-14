package ch28.d;

import java.lang.annotation.Repeatable;

//애노테이션 반복사용
//마이애노테이션2만 따로 여러번 사용할 수 있다.
@Repeatable(MyAnnotation2s.class)
public @interface MyAnnotation2 {

}
