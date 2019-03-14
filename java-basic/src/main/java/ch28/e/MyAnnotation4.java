package ch28.e;

public @interface MyAnnotation4 {//default가 선언되지 않은 모든 프로퍼티는 필수 입력이다,
	String value();//필수 프로퍼티. 이름 생략 불가
	String name();
	int age();
	boolean working();
}
