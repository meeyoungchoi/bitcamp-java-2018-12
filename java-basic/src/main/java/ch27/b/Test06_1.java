//reflaction api - 메서드의 상세정보 꺼내기
package ch27.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Test06_1 {

	public static void main(String[] args) throws Exception {

		Class<?> clazz = String.class;

		Constructor[] constructors = clazz.getConstructors();
		for (Constructor c : constructors) {
			System.out.printf("%s\n", c.getName());
			
			Parameter[] params = c.getParameters();
			for (Parameter p : params) {
				System.out.printf("  %s.%s\n",
						p.getName(),
						p.getType().getSimpleName());
			}
		}
	
		}
	}

