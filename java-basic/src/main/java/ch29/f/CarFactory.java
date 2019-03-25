package ch29.f;

public class CarFactory {
	public static Car create(String model) {//이 파라미터 값이 생성자 태그를 그대로 사용한다,
		Car c = new Car();

		switch (model) {
		case "tico":
			c.setMaker("쉬보레");
			c.setModel("티코2019");
			c.setCc(900);
			c.setValve(16);
			c.setAuto(true);
			break;
		case "sonata":
			c.setMaker("소나타");
			c.setModel("소나타2019");
			c.setCc(3500);
			c.setValve(16);
			c.setAuto(true);
			break;
		case "equus":
			c.setMaker("현대자동차");
			c.setModel("에쿠스 수프림");
			c.setCc(1200);
			c.setValve(16);
			c.setAuto(true);
			break;
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
