package design_pattern.decorator.before;

public class Hybrid extends Car{

	private static final int speed = 0;

	@Override
	public void run() {
		if (this.speed <= 60) {
			System.out.println("모더토 달린다.");
		} else {
			System.out.println("달린다.");
		}
	
	
}
}
