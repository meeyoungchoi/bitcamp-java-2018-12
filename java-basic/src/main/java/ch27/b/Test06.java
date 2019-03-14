//reflaction api - 메서드의 상세정보 꺼내기
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.apache.ibatis.javassist.Modifier;

import static java.lang.reflect.Modifier.*;

public class Test06 {

	public static void main(String[] args) throws Exception {

		Class<?> clazz = C.class;

		//상속 받은 메서드를 포함하여 모든 public 메서드의 
		
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			//메서드가 실제 정의된 클래스의 이름 출력하기
			System.out.printf(/*"메서드명: %s\n",m.getName()*/"메서드명:  %s\n",
					m.getDeclaringClass().getSimpleName()//해당 메서드가 정의된 클래스의 이름
					);
			System.out.printf(" ==> %s\n",m.getName());
			
			
			
		}
	}
}
