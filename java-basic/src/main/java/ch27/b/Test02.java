//reflaction api - 클래스(또는 인터페이스) 이름 알아내기
//즉 클래스 안을 들여다 볼때 사용하는 도구이다.
//메서드를 호출하면 이 메서드가 어떤 인터페이스의 메서드이고 파라미터 정보, 
package ch27.b;

import java.lang.reflect.Method;

public class Test02 {
	
	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = Calculator.class;
		
		Method[] methods = clazz.getMethods();//메서드 목록을 알고싶을 때
		for (Method m : methods) {
			System.out.println(m.getName());
		}		
	}

}
