package design_pattern.observer;



public class Test01 {
	public static void main(String[] args) {
	Car car = new Car();
	
	car.start();
	
	car.run();
	
	car.stop();
	
	System.out.println("===========================================");

	/*
	 * observer 패턴 적용
	 * 1.상태가 바뀌었을 떄 통지할 규칙을 정의하낟.
	 * 클래스의 상태가 바뀌었을 때 다른 클래스에게 통지해야 하는데,
	 * 그 방법이 메서드를 호출하는 것이다.
	 * carObserver 인터페이스 정의
	 * 
	 * 2. 상태가 바뀔 때 마다 다른 클래스에게 통지하는 기능을 추가한다.
	 * 상태가 바뀌었을 때 등록된 클래스에게 통지할 수 있도록 코드를 추가한다.
	 * Car 클래스에서 다음 메서드 추가
	 * -addObserver(carObserver)
	 * -removeObserver(carObserver)
	 * -notifyObserverOnStarted()
	 * -notifyObserverOnStopped();
	 * 
	 * */
	
	car.addObserver(new SafeBeltCarObserver());//1.
	car.start();
	car.run();
	car.stop();
	System.out.println("-----------------------------------------------------");
	
	car.addObserver(new EngineOilCarObserver());
	car.start();
	car.run();
	car.stop();
	System.out.println("---------------------------------------------------------");
	
	car.addObserver(new BreakOilCarObserver());
	car.start();
	car.run();
	car.stop();
	System.out.println("-----------------------------------------------------------");
	
	car.addObserver(new SunRoofCloseCarObserver());
	car.start();
	car.run();
	car.stop();
	System.out.println("-----------------------------------------------------------");
	}

}
