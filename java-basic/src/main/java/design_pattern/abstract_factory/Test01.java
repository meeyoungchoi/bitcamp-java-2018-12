//템플릿 메서드 패턴 -factory 객체를 추상화 시키는 방식, 다양한 factory로 대체할 수 있다.
package design_pattern.abstract_factory;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
	//설계
	//UnitFactory 인터페이스: 공장 객체의 사용 규칙을 정의
	//AbstractUnitFactory 추상 클래스: UnitFactory의 사용규칙을 구현, 일부 메서드는템플릿으로 구현.
	//TerranUnitFactory 클래스: AbstractUnitFactory 서브 클래스. 테란족에 맞춰서 유닛 생성.
	//ProtossUnitFactory 클래스: AbstractUnitFactory 서브 클래스. 프로토스족에 맞춰서 유닛 생성
	//ZergUnitFactory 킄래스: UnitFactory 구현 클래스. 저그족에 맞춰서 유닛 생성
	//
		
		Scanner keyboard = new Scanner(System.in);
		int type;
		do {
		System.out.print("종족을 선택하시요?(1:태란 2:프로토스 3:저그)");
		type = keyboard.nextInt();
		if (type < 1 && type < 4) {
			System.out.println("번호가 맞지 않습니다.");
		}
		break;
		
		} while (true);
		
		UnitFactory unitFactory = null;
		switch (type) {
		case 1:
			System.out.println("태란족을 선택하셨습니다.");
			unitFactory  = new TerranUnitFactory();
			break;
		case 2:
			System.out.println("프로토스족을 선택하셨습니다.");
			unitFactory = new ProtosUnitFactory();
			break;
		case 3:
			System.out.println("저그족을 선택하셨습니다.");
			unitFactory = new ZugUnitFactory();
			break;
		}
	
	
	
		
		// 식당 짓기(레퍼런스 변수)
		Unit u1 = unitFactory.createUnit(UnitFactory.RESTAURANT);
		u1.build();//
		
		System.out.println("+++++++++++++++++++++++++++==++++++++++++++++++++");
		//훈련소 
		
		Unit u2 = unitFactory.createUnit(UnitFactory.TRAINING_CENTER);
		u2.build();
		
	}
	
			

}
