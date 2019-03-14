//reflaction api - 클래스가 구현한 인터페이스 알아내기
package ch27.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Test08 {

	public static void main(String[] args) throws Exception {

		Class<?> clazz = String.class;//.class:스태틱 변수(String) 클래스이름:string
		
		//String.class 클래스는 어떤 인터페이스를 구현했는가
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> c : interfaces) {
			System.out.println(c.getName());
			
		}

	}

}


