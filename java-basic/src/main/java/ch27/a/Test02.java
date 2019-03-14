//여러개의 인터페이스 구현한 객체를 자동으로 생성하기
package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import ch09.Calculator1;

public class Test02 {

	public static void main(String[] args) {
		
		//
		 Object proxy = (Calculator)Proxy.newProxyInstance(
				 Test02.class.getClassLoader(),
				 new Class[] {Calculator.class, Calculator2.class, Calculator3.class},
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					
						int a = (int) args[0];
						int b = (int )args[1];
						switch (method.getName()) {
						
						case "plus":
							return a + b;

						case "minus":
							return a - b;
							
						case "multiple":
							return a * b;
							
						case "divide":
							return a / b;
						
							
						case "mod":
							return a % b;
						}
						return 0;
					
					
					}
					 
				 });
		 	Calculator c1 = (Calculator) proxy;
		 	Calculator2 c2 = (Calculator2) proxy;
		 	Calculator3 c3 = (Calculator3) proxy;
		 		 
		 	 System.out.println(((Calculator) proxy).plus(10, 20));
			 System.out.println(c1.minus(10, 20));
			 System.out.println(c2.multiple(10, 20));
			 System.out.println(c2.divide(10, 20));
			 System.out.println(c3.mod(10, 20));
		
	
			
		}


}


