package ch28.e;

public @interface MyAnnotation5 {
	String value();//필수 프로퍼티. 이름 생략 불가
	String name() default "홍길동";
	int age() default 20;
	boolean working();
}
