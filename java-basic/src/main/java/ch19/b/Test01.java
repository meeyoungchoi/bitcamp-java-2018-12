//상수를 다른 클래스로 분류하기 전
package ch19.b;

public class Test01 {

	public static void main(String[] args) {
		Product p = new Product();
		p.maker = "비트컴퓨터";
		 p.title = "비트마우스";
		 p.price = 90000;
		 
		 //
		 p.category = Product.COMPUTER_MOUSE;
		 
		 //문제점
		 //분류 항목이 추가될 때 마다 Product 클래스를 변경해야 한다.
		 //Product 클래스가 변경되며 기존에 작성한 코드가 영향을 받는다.
		 //한 클래스가 분류 정보와 같은 다른 정보까지 관리하면 유지보수에도 좋지 않다.
		 //해결책
		 //분류 코드를 정의한 상수를 다른 클래스로 분리 해보자
		 
		 

	}

}
