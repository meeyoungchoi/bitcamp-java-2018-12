//lambda문법 -람다 파라미터1
package ch19.h;

public class Test04 {
	
	//다음과 같이 추상 메서드가 한 개 있는 인터페이스를 functional interface라고 부른다.
	//이런 경우에 람다 문법을 사용할 수 있다.
	static interface Player {
		void play(String name, int age);
	}
	
	public static void main(String[] args) {
		//1.
		Player p1 = (String name, int age) -> 
		System.out.printf("%s(%d)님 환영합니다.\n",name,age);
		p1.play("홍길동",20);
	
		//2.
		Player p2 = (name, age) -> System.out.printf("%s(%d)님 환영합니다.\n",name,age);
		p2.play("임꺽정",30);
		
		//3.파라미터가 여러개 일때는 괄호를 생햑할 수 없다.
		//Player p3 = name, age -> System.out.printf("%s(%d)님 환영합니다.\n",name,age);
		//p3.play("임꺽정",30);
	}
}
