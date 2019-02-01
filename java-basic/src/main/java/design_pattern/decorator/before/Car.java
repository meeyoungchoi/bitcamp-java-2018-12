package design_pattern.decorator.before;

public abstract class Car {
	
	public void start() {
		System.out.println("시동건다!");
	}
	
	public void stop() {
		System.out.println("시동건다!");
	}
	
	public abstract void run();

}
