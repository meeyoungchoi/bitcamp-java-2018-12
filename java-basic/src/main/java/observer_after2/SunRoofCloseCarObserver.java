package observer_after2;

public class SunRoofCloseCarObserver extends AbstractCarObserver {
	
	
	public void carStopped() {
		System.out.println("썬루프 닫는다.");
	}
	

}
