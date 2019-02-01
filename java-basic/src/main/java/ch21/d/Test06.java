//예외 던지기 - Runtime exception 예외던지기2
package ch21.d;

import java.util.ArrayList;

public class Test06 {
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) /*throws Exception*/{
		//main()에서 RuntimeException 예외를 처리하지 않으면
		//당연히 그 상위 호출자에게 전달된다.
		//
		//RuntimeException은 
		//
		//
		m3();
		System.out.println("종료");
			
	}
	
	static void m3()  {
		// Exception 예외를 발생키키는 메서드를 호출할 때는
		//1.try catch로 예외를 처리하거나
				//2.throws 절을 사용하여 어떤 예외가 발생하는지를  호출자에게 우임(선언,보고)해야 한다.
		m2();
	}
	
	static void m2()  {
		//RuntimeException예외를 발생시키는 메서드는 
		//반드시 메서드 선언부에 어떤 예외를 던지는지 선언하지 않아도 된다.
		//try catch로 처리하지 않아도 된다.
		m1();
	}
	
	static void m1()  {
		//RuntimeException예외를 발생시키는 메서드는 
		//반드시 메서드 선언부에 어떤 예외를 던지는지 선언하지 않아도 된다.
		throw new RuntimeException("m1()에서 발생한 예외");
	}
}

//
