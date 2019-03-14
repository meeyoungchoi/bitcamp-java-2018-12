package ch28.e;

public @interface MyAnnotation3 {
	String value() default "오호라";//필수 프로퍼티. 이름 생략 불가
}
