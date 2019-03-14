//여러개의 인터페이스 구현한 객체를 자동으로 생성하기 - 람다 적용(lambda)
package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import ch09.Calculator1;

public class Test03 {

	public static void main(String[] args) {

		/*
		class MyClass implements InvocationHandler {
			public Object invoke(Object proxyObj, Method method, Object[] params) {
				return null;
			}
		}
		
		Object obj = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		
		//Object obj2 = (Object proxyObj, Method method, Object[] params) -> {
		InvocationHandler obj2 = (Object proxyObj, Method method, Object[] params) -> {
			return 0;
		}
			
		*/
		
	    // Calculator, Calculator2, Calculator3 인터페이스를 구현한 
	    // 클래스를 만들고 그 인스턴스를 생성하여 리턴한다.
		Object proxy = (Calculator)Proxy.newProxyInstance(
				Test03.class.getClassLoader(),
				new Class[] {Calculator.class, Calculator2.class, Calculator3.class},
				(Object proxyObj, Method method, Object[] params) ->{
					//newProxyInstance()가 생성한 객체에 대해 메서드를 호출할 때마다 이 메서드가 호출된다.
					int a = (int) params[0];
					int b = (int)params[1];
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


