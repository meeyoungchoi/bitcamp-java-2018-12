package after;

//
public class EngineOilCarObserver implements CarObserver {
	
	//자동차의 시동이 걸렸을 때 호출할 메서드
	//보통 메서드의 이름은 동사로 시작하는데,
	//옵저버에게 통지할 때 호출하는 메서드는 
	//명사구의 상태 이름으로 정의할 수 있다.
	public void carStarted() {
		System.out.println("엔진오일 유뮤 검사");
	}

	//자동차의 시동이 종료되었을 때 홏
	public void carStopped() {
		
	}
}
