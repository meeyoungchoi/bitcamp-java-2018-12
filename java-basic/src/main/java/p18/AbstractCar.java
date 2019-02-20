package p18;

public class AbstractCar {
	String model;
	int cc;
	
	//추상 클래스의 목적: 서브 클래스에게 공통 필드와 공통 메서드를 상속해주는 
	public void on() {//서브클래스?
		System.out.println("시동을 견다.");
	}
	
	public void off() {//서브클래스?
		System.out.println("시동을 끈다.");
	}
	
	
	
	
}
