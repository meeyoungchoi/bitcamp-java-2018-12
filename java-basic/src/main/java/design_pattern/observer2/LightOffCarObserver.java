package design_pattern.observer2;

public class LightOffCarObserver implements CarObserver {

	@Override
	public void carStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void carStopped() {
		System.out.println("전조등을 끈다.");
	}

}
