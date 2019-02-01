//lambda문법 - 람다문법1
package ch19.h;

public class Test02 {
	
	//다음과 같이 추상 메서드가 한 개 있는 인터페이스를 functional interface라고 부른다.
	//이런 경우에 람다 문법을 사용할 수 있다.
	static interface Player {
		void  play(String name);
	}
	
	public static void main(String[] args) {
		//한
		Player p1 = (String name) -> System.out.println("테스트1");
		p1.play("라라");
		
		//
		Player p2 = (String name) -> {System.out.println("테스트1");};
		
	}
}
