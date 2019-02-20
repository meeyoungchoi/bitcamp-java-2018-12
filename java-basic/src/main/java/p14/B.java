package p14;

public class B extends A {

	//오버라이딩 규칙
	//1. 메서드 시그너처(메서드명, 파라미터, 리턴타입)을 똑같게 해야한다.
	//@Override
	//void m1(int a) {
		// TODO Auto-generated method stub
		//super.m1(a);
	//}
	
	//리턴타입이 다르면 안된다.
	//@Override
	//int m1(int a ) {}
	
	//파라미터의 개수가 다르면 안된다.
	//@Override 
	//void m1(int a, int b) {}
	
	//접근 범위를 축소하는 것은 안된다.
	//@Override
	//private void m1(int a) {}
	
	//접근 범위를 확대하는 것은 괜찮다.
	@Override 
	public void m1(int a) {}
}
