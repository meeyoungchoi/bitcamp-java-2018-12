package after;

import java.util.HashSet;

public class Car {
	
	//옵저버 목록을 저장할 집합객체 준비
	//같은 객체가 중복 등록되지 않도록 한다.
	//등록 순서에 따라 통지할 필요는 없다,
	//
	HashSet<CarObserver> observers = new HashSet<>();
	
	//옵저버를 관리하는 메서드 추가
	public void addObserver(CarObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(CarObserver observer) {
		observers.remove(observer);
	}
	
	//자동차의 시동을 시작할 때 통지한다.
	public void notifyObserversOnStarted() {
		for (CarObserver observer : observers) {
			observer.carStarted();
		}
	}
	
	//자동차의 시동을 끌때 통지한다.
	public void notifyObserversOnStopped() {
		for (CarObserver observer : observers) {
			observer.carStopped();
		}
	}
	
	public void start() {
		System.out.println("시동을 건다.");
		
		notifyObserversOnStarted();
		
		//예 1월 20일 - 자동차 시동을 걸 때 안전 벨트 착용 여부를 검사하는 기능을 추가
		
		
		//2월 30일 - 자동차 시동을 걸 때 엔진 오일 유무를 검사하는 기능을 추가
	
		
		//3월 2일 - 자동차 시동을 걸때 브레이크오일 유무 검사
	
		
		//4월 15일 - 
	}
	
	public void run() {
		System.out.println("달린다.");
	}
	
	public void stop() {
		System.out.println("시동을 끈다.");
		
		notifyObserversOnStopped();
		
		//4월 15일 - 자동차 시동을 끌 때 전조등 자동 끄기 기능 추가
		
		
		//5월 5일 - 자동차 시동을 끌 때 썬루프 자동 닫기 기능 추가

	}

	public void addObserver(SafeBeltCarObserver safeBeltCarObserver) {
		// TODO Auto-generated method stub
		
	}

	public void addObserver(EngineOilCarObserver engineOilCarObserver) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
