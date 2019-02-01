package design_pattern.decorator.after;

public class SunRoof extends Decorator{
	boolean openSunRoof;
	
	public SunRoof(Car car) {
		super(car);
	}
	
	
@Override
public void run() {
	//생성자에서 받은 자동차에 덧붙인 썬루프 기능을 실행한다.
	if (openSunRoof) {
		System.out.println("썬루프를 연채로");
	} else {
		System.out.println("썬루프를 닫은채로");
	}
	//System.out.println("달린다");
	//생성자에서 받은 원래의 자동차를 실행하낟.
	this.car.run();
}

public void openSunRoof() {
	this.openSunRoof = true;
	}

public void closeSunRoof() {
	this.openSunRoof = false;
	}
}
