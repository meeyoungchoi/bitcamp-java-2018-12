package design_pattern.decorator.after;

public class Test01 {

	public static void main(String[] args) {
		
		// Decorator 패턴이 적용된 자동차를 만들어 써보자
		//
		//Decorator 디자인 패턴의 목표
		//=>기능을 플러그인처럼 붙였다 뗐다를 자유롭게 하기위함이다.
		//
		Truck c1 = new Truck();//덜컹덜컹 달린다.
		Hybrid c2 = new Hybrid(c1);//Hybid(덜컹덜컹 달린다.)
		c2.run();
		System.out.println("====================================");
		//만약 hybrid 이면서 convertiable 기능을 갖는 자동차를 만들고 싶다면?
		//hybrid나 Convertible 둘 중 한 개를 상속 받아서 구현해야 한다.
		//하위 클래스는 다른 클래스의 기능을 중복해서 개발해야 한다.
		//
		Convertiable c3 = new Convertiable(c2);//전기모터를 켜고 덜컹덜컹 달린다.
		c3.openRoof(true);//전기모터를 켜고 덜컹덜컹 달린다 지붕을 연다.
		c3.run();
		System.out.println("====================================");
		//Hybrid 기능 빼고 Sedan에 Convertible 기능을 달자.
		Sedan s1 = new Sedan();//달린다.
		Convertiable c4 = new Convertiable(s1);//컨버터블에 에스1을 넣은게 시4이다.
		c4.openRoof(true);//달린다 지붕을연다.
		c4.run();//세단이 달린다.
		
		System.out.println("====================================");
		
		Dump c5 = new Dump(c4);//달린다 지붕을 연다 짐을 내린다.//컨버트//Car car = c4
		c5.run();//이 run은 public void run() dump에있는
		
		System.out.println("====================================");
		
		Dump c6 = new Dump(c3);//전기모터를 켜고 덜컹덜컹 달린다 지붕을 연다. 짐을내린다. 컨버터블
		c6.run();
	}
}
