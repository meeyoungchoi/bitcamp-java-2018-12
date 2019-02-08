package observer_after;

public class SafeBeltCarObserver implements CarObserver {
	public void carStarted() {
		System.out.println("안전벨트 착용 여부 검사");
	}
	
	
	public void carStopped() {
		
	}
	

}
