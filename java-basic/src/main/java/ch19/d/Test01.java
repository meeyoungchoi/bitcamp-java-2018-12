//static nested class를 응용하여 상수를 관리할 떄 이점
package ch19.d;


public class Test01 {

	public static void main(String[] args) {
		Product p = new Product();
		p.maker = "비트컴퓨터";
		 p.title = "비트마우스";
		 p.price = 90000;
		 
		 
		 //분류를 지정할때 OGNL방식으로 표현
		 //Object Graph Navigation Language =>객체의 하위 프로퍼티 값에 접근 하는 표기법
		 //문법
		 //객체.프로퍼티명.프로퍼티명.프로퍼티명 = 값;
		 //자바는 기본으로 객체의 필드를 사용할 때 (.)을  이용하여 지정한다.
		 //그 하위 필듸도 마찬가지로 (.)을 이용하여 지정할 수 있다.
		 //이런식으로 .을 이용하여 하위 필드를 지정하는 표기법을  OGNL이라고 한다.
		 // static nested class를 사용하면 
		 p.category = Category.computer.mouse.bluetooth;
		 
		 //
		 //
		
		 
		
		 
		 

	}

}
