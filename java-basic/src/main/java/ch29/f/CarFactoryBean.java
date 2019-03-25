package ch29.f;

import org.springframework.beans.factory.FactoryBean;

//스프링 ioc 컨테이너의 규칙에 따라 팩토리 클래스 만들기
public class CarFactoryBean implements FactoryBean<Car> {//Car를 만들어주는 공장객체 : ~FactorBean => 스프링 규칙에 따라서 만든 공장 클래스이다.
	//이 공장은 Car를 만들어주는 공장이다.

	BlackBox blackBox;
	String model;

	public CarFactoryBean(BlackBox blackBox, String model) {
		System.out.println("CarFactoryBean()");
		this.blackBox = blackBox;
		this.model = model;
	}


	@Override
	public String toString() {
		return "CarFactoryBean [blackBox=" + blackBox + ", model=" + model + "]";
	}



	@Override
	public Class<?> getObjectType() {//객체 타입은 카 클래승다.

		return Car.class;
	}

	@Override
	public Car getObject() throws Exception {

		Car c = new Car();
		c.setBlackBox(blackBox);

		switch (model) {
		case "tico":
			c.setModel("쉬보레");
			c.setModel("티코2019");
			c.setCc(900);
			c.setValve(16);
			c.setAuto(true);
		case "sonata":
			c.setModel("소나타");
			c.setModel("소나타2019");
			c.setCc(3500);
			c.setValve(16);
			c.setAuto(true);
		case "equus":
			c.setModel("현대자동차");
			c.setModel("소나타 골드");
			c.setCc(1200);
			c.setValve(16);
			c.setAuto(true);
		default:
			c.setMaker("비트자동차");
			c.setModel("비트카트");
			c.setCc(1200);
			c.setValve(16);
			c.setAuto(true);
	
		}
		return c;

	}
}