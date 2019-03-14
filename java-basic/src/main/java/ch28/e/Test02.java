//애노테이션 프로퍼티
//=>메서드 선언하는 문법과 비슷하다.
//=>기본 값을 지정하지 않으면 필수 입력이다,
//=>value라는 이름을 갖는 프로퍼티의 경우
//값을 지정할 때 이름을 생략할 수 있다.
package ch28.e;

//@MyAnnotation//필수 프로퍼티가 있는 겨우 값을 반드시 지정해야 한다,
public class Test02 {
	
@MyAnnotation4(
		value="okok",
		name="홍길동",
		age=20,
		working=true)
int a;	

/*
@MyAnnotation4(
		//"okok",//value 외에 다른 속성의 값도 함께 설정할 경우 value 이름 생략 불가
		//value가 한개 있을 때만 생략할 수 있다.
		name="홍길동",
		age=20,
		working=true)
		*/
int b;	

//@MyAnnotation5("okok")//value 프로퍼티 값만 설정할 경우에 이름을 생략할 수 있다. value=이 
int c;
}
