package design_pattern.decorator.after;

public abstract class Car {
	protected int speed;
	protected int capacity;
	
	public void start() {
		System.out.println("시동건다!");
	}
	
	public void stop() {
		System.out.println("시동끈다.!");
	}
	
	public abstract void run();

}
