package ch24.d;

public class Test01 {
	
	public static void main(String[] args) {
		Account acc = new Account("홍길동", 1000000);
		
		ATM kang101 = new ATM("강남-101", acc);
		ATM kang102 = new ATM("강남-102", acc);
		ATM kang103 = new ATM("강남-103", acc);
		
		kang101.start();//얘 실행이 끝날때까지 다음라인으로 가지 않는다. 스레드를 사용하지 않았으므로 순차적으로 찾는다.
		kang102.start();
		kang103.start();
		
		//세마포어(n): 동시에 그 코드를 진입하는 개수
		//크리티컬 섹션에 진입할 수 있는 스레드의 수를 지정한다.
		//자바에서는 세마포어를 지원하지 않느다.
		//개발자가 직접 처리해야 한다.
		//
		//뮤텍스(mutual exclusion, 상호배제)
		//한번에 오직 한 개의 스레드 만이 크리티ㅋ컬 섹션에 접근할 수 있다.
		//예) 선풍기 풍량세기,  라디오, tv채널, 화장실 변기
		//세마포어 1과 같다.
		//자바는 싱크로나이즈드 키워드를 통해 뮤텍스를 사용할 수 있다.
	}
	
	
	

}
