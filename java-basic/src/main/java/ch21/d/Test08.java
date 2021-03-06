//예외 던지기 - Runtime exception 예외던지기3
package ch21.d;

import java.util.ArrayList;

public class Test08 {
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) {

		try {
			m3();
		} catch (RuntimeException e) {
			System.out.println(e.toString());
		}
		
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
	
	static void m1() throws RuntimeException  {
		//RuntimeExceptin 예외가 최초로 발생되는 메서드를 만들 때는
		//가능한 메서드 선언부의 throws 절에 어떤 예외가 발생하는 지 적어라
		//
		//
		throw new RuntimeException("m1()에서 발생한 예외");
	}
}

//
