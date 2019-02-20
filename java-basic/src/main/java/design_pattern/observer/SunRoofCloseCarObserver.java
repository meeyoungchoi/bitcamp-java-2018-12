package design_pattern.observer;

public class SunRoofCloseCarObserver implements CarObserver{

	@Override
	public void carStarted() {
		
		
	}

	@Override
	public void carStopped() {
		System.out.println("썬루프 닫는다.");
		
	}

}
