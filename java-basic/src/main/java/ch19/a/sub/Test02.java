//중첩 클래스
package ch19.a.sub;

//익명 클래스의 예제를 위한 클래스
class Car {
	String model;
	
	public void run() {
		System.out.println("달린달.");
	}
	public Car() {
		 this.model = "미정";
		
	}
	
	public void write() {
		
	}

	public Car(String model) {
		this.model = model;
	}
}
//익명클래스의 예제를 위한 인터페이스
interface Pen {
	void write();
}

public class Test02 {
	//중첩 클래스
	//=>특정 클래스 안에서만 사용되는 클래스가 있다면 중첩 클래스로 선언하라
	//=>즉, 노출 범위를 촙히는 것이 유지보수에 좋다.
	//많이 노출되면 안좋다.
	
	//1. 중첩 static class = top 
	//바깥 클래스의 특정 인스턴스에 종속됨이 없이(되지 않는) 사용할 수 있는 클래스
	static class A{}
	
	//2. 중첩 클래스 - non-static nested class = inner class
	//바깥 클래스의 특정 인스턴스에 종속되는 클래스
	class B {}
	
	public static void main(String[] args) {
	//3. Local class
	//특정 메서드 안에서만 사용되는 클래스
	class C {}
	
	//4. anonymous class
	//클래스의 이름이 없다.
	//그래서 클래스를 정의하는 동시에 인스턴스를 생성해야 한다.
	//클래스 이름이 없기 때문에 생성자를 정의할 수 없다.
	//만약 인스턴스의 값을 초기화시키기 위해 복잡한 코드를 사용해야 한다.
	//단 한 개의 인스턴스만 생성해서 사용할 경우 익명 클래스를 적용한다.
	// 문법
	// new 수퍼클래스( ){클래스 정의}
	//new 인터페이스() {클래스 정의}
	
	//예1.
	//Car  크래릇를 상속 받고, Car의 기본 생성자를 호출하는 익명 클래스 정의 및 객체 생성
	//인스턴스를 생성할 때 수퍼 클래스인 Car의 기본 생성자를 호출한다.
	//클래스를 정의하면서 동시에 인스턴스를 생성하고 있다.
	//Car obj = new Car() {}
	Car obj = new Car() {
		@Override
		public void run() {
			System.out.println(this.model + "달려라! 달려라!");
		}
	};//new 명령은 인스턴스를 생성하는 명령이기 때문에 문장 끝에 세미콜론을 붙여야 한다.
	obj.run();
	
	
	//클래스 이름 다음에 오는 것이 수퍼 클래스의 생성자를 지정하는 문법이다.
	Car obj2 = new Car("티코") {
		@Override
		public void run() {
		System.out.println(this.model +"경차 달린다!");
		}
	}; 
	obj2.run();
	
	//예3.
	//인터페이스를 구현하여 익명 클래스를 만들기
	//인터페이스를 지정하면 수퍼 클래스는 자동으로 Object 가 된다.
	//그러면 호출할 생성자도 object 클래스의 생성자이어야 한다
	//pen obj3 = 300;
	Pen obj3 = new Pen() {
		@Override
		public void write() {
			System.out.println("글 쓴다.");
		}
	};
	obj3.write();
	}
	
	//
	public static void m1() {
		// 스태틱 
		A obj = new A();
		
		//스태틱 멤버는 인스턴스 주소를 담는 this라는 
		//
		B  obj2;//
		//obj2 = new B(); //컴파일 오류
		
		//다른 로컬 
		//C obj3;//컴파일 오류 
		//obj3 = new C();//
	}
	
}



	



