package design_pattern.decorator.after;

public class Hybrid extends Decorator{
	
	
	public Hybrid(Car car) {
		super(car);
	}
		
@Override
public void run() {
	//생성자에서 받은 자동차에 덧붙인 전기모터 기능을 실행한다.
	System.out.println("전기 모터를 켜고,");
	//System.out.println("달린다");
	//생성자에서 받은 원래의 자동차를 실행하낟.
	this.car.run();
}

}
