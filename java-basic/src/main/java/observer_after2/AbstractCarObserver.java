package observer_after2;

// CarObserver를 직접 구현하면
//CarObserver에 선언된 모든 메서드를 구현해야 한다.
//관심이 없는 메서드도 구현해야 한다.
//이런 불편함을 줄이기 위해 다음과 같이 추상 클래스를 정의한다.
//즉 추상 클래스에서 CarObserver 인터페이스의 메서드를 모두 구현한다.
//그러면 Observer를 직접 구현하는 대신에
//다음 추상 클르래스를 상속 받아 필요한 메서드만 오버라이딩 하는 것이 편하다.
//
public class AbstractCarObserver implements CarObserver {

	@Override
	public void carStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void carStopped() {
		// TODO Auto-generated method stub
		
	}

}
