package design_pattern.decorator.after;

public class Convertiable extends Decorator{

	boolean openRoof;

	public Convertiable(Car car) {//car타입의 s1이들어간다.
		super(car);
	}

	@Override
	public void run() {//카타입의 컨버터블을 여기에 붙인다.
		//생성자에서 받은 자동차에 덧붙인 자동차 지붕 열기 기능을 실행한다.

		//System.out.println("달린다");
		//생성자에서 받은 원래의 자동차를 실행하낟.
		this.car.run();//s1.run()

		//생성자에서 받은 자동차에 덧붙인 자동차 지붕열기 기능을 실행한다.
		if (this.openRoof ) {
			System.out.println("지붕을 연다!");
		} else {
			System.out.println("지붕을 닫는다.");
		}
	}

	public void openRoof(boolean openRoof1) {
		this.openRoof = openRoof1;
	}

}
