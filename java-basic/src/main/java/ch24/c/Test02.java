//스레드와 프로그램 종료
package ch24.c;

import java.util.Scanner;

public class Test02 {

	//1. Thread 클래스를 상속 받아 정의하기
	//구현하기 편하다.
	//그런데 다중 상속이 불가능하기 때문에 다른 클래스를 상속 받을 수 없다.
	//즉 마이스레드가 다른 클래스를 상속 받으면서 스레드가 될 순 없다.
	//직접적으로 
	static class MyThread extends Thread {
		//스레드에서 독립적으로 실행할 코드를 run() 메서드에 작성하라
		@Override
		public void run() {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("입력하시요>");
			String input = keyboard.nextLine();
			System.out.println("입력한 문자열 ==> " + input);
			keyboard.close();
		}
	}
	
	
	public static void main(String[] args) {
		
		//main스레드에서 다른 스레드 인스턴스 생성하기
		//어떤 슬레드에서 생성한 스레드를 그 스레드의 자식 스레드라 부른다.
		//즉 다음 스레드는 main 스레드의 자식 스레드이다.
		//자식 스레드는 부모 스레드와 같은 우선 순위를 갖는다.
		MyThread t = new MyThread();
		t.start();
		
		//자식 스레드가 모두 완료할 때까지 부모 스레드는 종료되지 않느다.
		//모든 스레드가 완료할 때까지 jvm은 종료되지 않는다.
		System.out.println("프로그램 종료?");
	}

}

//jvm의 스레드 계층도:
//main(T)