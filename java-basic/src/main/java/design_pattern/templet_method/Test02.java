//템플릿 메서드 패턴 -수퍼 클래스에 기본 실행 흐름을 정의하고 서브 클래스에 세부 항목을 구현한다.
package design_pattern.templet_method;

public class Test02 {

	public static void main(String[] args) {
	//유닛 객체를 직접 생성하지 않고 공장 객체를 통해 생성한다.
	
	UnitFactory unitFactory = new UnitFactory();
		
	// 식당 짓기(레퍼런스 변수)
	Unit u1 = unitFactory.createUnit(UnitFactory.RESTAURANT);
	u1.build();//
	
	System.out.println("+++++++++++++++++++++++++++==++++++++++++++++++++");
	//훈련소 
	
	Unit u2 = unitFactory.createUnit(UnitFactory.TRAINING_CENTER);
	u2.build();

	u2.build(); 
		
	}

}
