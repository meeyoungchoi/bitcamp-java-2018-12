package after;

public class BreakOilCarObserver implements CarObserver {
	public void carStarted() {
		
	}
	
	
	public void carStopped() {
		System.out.println("전조등을 끈다.");
	}
	

}
