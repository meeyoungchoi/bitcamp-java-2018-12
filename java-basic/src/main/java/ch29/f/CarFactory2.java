package ch29.f;

public class CarFactory2 {

	BlackBox blackBox;

	public CarFactory2(BlackBox blackBox) {
		System.out.println("CarFactory2()");
		this.blackBox = blackBox;
	}

	@Override
	public String toString() {
		return "CarFactory2 [blackBox=" + blackBox + "]";
	}

	public Car create(String model) {//이 파라미터 값이 생성자 태그를 그대로 사용한다,
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
