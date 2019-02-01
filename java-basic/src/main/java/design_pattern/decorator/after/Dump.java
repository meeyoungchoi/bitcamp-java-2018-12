package design_pattern.decorator.after;

public class Dump extends Decorator{

	public Dump(Car car) {//c4
		super(car);//c4
	}
		
@Override
public void run() {
	//생성자에서 받은 자동차에 덧붙인 짐내리기 기능을 실행한다.
	this.car.stop();//c4.stop()
	this.dump();//해당 클래스부터 dump라는이름의 메서드를 호출한다. 이 클래스에서 dump라는 이름의 메서드를 찾는다.
	
	//System.out.println("달린다");
	//생성자에서 받은 원래의 자동차를 실행하낟.
	this.car.run();//c4.run()
}

public void dump() {
	System.out.println("짐을 내린다.");
}

}
