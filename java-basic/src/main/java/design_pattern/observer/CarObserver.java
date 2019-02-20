package design_pattern.observer;

//자동차의 상태가 바뀌었을 때 호출할 메서드 규칙을 정의한다.(CarObserver)
public interface CarObserver {

	//자동차의 시동이 걸렸을 때 호출할 메서드
	//보통 메서드의 이름은 동사로 시작
	//옵저버에게 통지랗 때 호출하는 메서드는
	//명사구의 상태 이름으로 정의할 수 있다.
	void carStarted();
	
	void carStopped();
	
}
