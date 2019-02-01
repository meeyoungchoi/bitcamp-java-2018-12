package design_pattern.decorator.after;

//자동차에 추가 기능을 덧붙이는 역할을 한다.
//=>다른 부속품의 수퍼 클래스 역할을 한다.
//=>그래서 추상 클래스로 정의한다.
public abstract class Decorator extends Car{
	
	//비록 Car를 상속 받았지만 스스로 Car일을 하지는 않는다.
	//단지 다른 자동차에 긴으을 덧붙인다.
	//=>생성자에서 반드시 기능을 덧붙일 대상이 되는 자동차를 받아야 한다.
	public Decorator(Car car1) {//카타입의  s1///c4
		this.car = car1;//this가 car라는 이름을 찾는다.//Car car = c4
	}
	
	Car car;//s1데이터를 담는다.
	
}
