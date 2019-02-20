package design_pattern.observer;

import java.util.HashSet;



public class Car {
	//옵저버 목록을 저장할 집합객체 준비
	//같은 옵저버가 중복 등록되지 않도록 한다.
	//등록 순서에 따라 통지할 필요는 없다.
	HashSet<CarObserver> observers = new HashSet<>();
	
	public void addObserver(CarObserver observer) {//2. observer: SeatBeltCarObserver()/BreakOilCAROBSERVER/engineOilCarObserver
		observers.add(observer);
	}
	

	public void notifyObserverOnStarted() {
		for (CarObserver observer : observers) {
			observer.carStarted();
		}
	}
	
	public void notifyObserverOnStopped() {
		for (CarObserver observer : observers) {
			observer.carStopped();
		}
	}
	
	public void start() {
		System.out.println("시동을 건다");
		
		notifyObserverOnStarted();
	}

	public void run() {
		System.out.println("달린다.");
		
	}

	public void stop() {
		System.out.println("시동을 끈다.");
		
		notifyObserverOnStopped();
		
	}
	

	
}
