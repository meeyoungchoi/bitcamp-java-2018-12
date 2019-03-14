//인터페이스 구현체를 자동으로 생성하기
package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test01 {

	public static void main(String[] args) {
		//java.lang.reflect.Proxy
		//인터페이스 구현체를 만드는 역할을 한다.
		//
		//newProxyInstance(
		// 구현체를 만들기 위해 사용하는 인터페이스의 클래스로더.
		// 구현할 인터페이스 목록,
		//실제 작업을 수행하는 객체)
	 //=>파라미터로 넘겨 받은 인터페이스를 모두 구현한 클래스를 만들어 리턴한다.
		//
		//클래스 로더
		//클래스 정보를 로딩하는 역할을 수행한다.
		//클래스 로더를 알아내는 방법(클래스로더를 얻는 방법):
		//클래스정보.getClassLoader()
		//클래스정보를 얻는 방법
		//인스턴스.getClass()
		//클래스명.class
		//.class:클래스명의 정보를 불러오기 위한 방법
		//Class.forNmad("패키지명을 포함한 클래스명")
		//클래스 정보를 얻는 방법 예)
		/*String s = "hello"; 
		Class<?> c1 = String.class;//클래스의 static 변수인 class의 값을 사용할 수 있다.
		Class<?> c2 = s.getClass();//인스턴스로  클래스 정보를 알아낼수 있다.
		Class<?> c3 = Class.forName("java.lang.String");//클래스 정보를 리턴하는 도구를 이용(패키지 이름이 계속 바뀌는 경우에 클래스 정보를 얻는 방법)
		*/
		
		/*int a = 10 , b= 20, c=30;
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		int[] arr2 = new int[] {10, 20, 30};
		
		int[] arr3 = {10, 20, 30};
		
		int[] arr4;
		arr4 = new int[] {10, 20, 30};//new int[] 생략 불가.
		*/
		//Class<?> c1 = Class.forName("ch27.a.Calculator");
					//   = Calculator.class;
		//Class<?> c2 = Iterator.class;
		/*Class<?>[] classes = new Class[] {c1, c2};
		Class<?>[] classes2 = new Class[2];
		classes[0] = clazz;
		Class<?>[] classes = new Class[] {Calculator.class};
		*/
		//실제 작업을 수행하는 객체
		//import java.lang.reflect.InvocationHandler 인터페이스에 따라 동작하는 객체
		//즉 InvocationHandler 구현체
		//
		
		//실제로 일을 해주는 객체(클래스, 인스턴스 )
		
		//마이핸들러: 인터페이스를 구현한 클래스이름
		class MyHandler implements InvocationHandler {
			//proxy에서 invoke메서드를 호출하기위해서 MyHandler객체가 InovocationHandler 인터페이스를 구현한건가?

			//proxy에는 proxy.newProxyInstance 메서드 구현?
			//MYBATIS에서 사용하는 기술 : 마이바티스가 클래스를 자도으로 만들어주는 기술이다.(dao구현체를 자도응로 만들어준다.)
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// newProxyInstance()가 생성한 객체에
				//System.out.println("==>" + method.getNaeme());
				int a = (int) args[0];//autounboxing: (Integer)args[0].intValues(); 이 인티저 객체에 대햐서 
				int b = (int )args[1];//autounboxing: (Integer)args[1].intValues(); 1번방에 들어있는 인티저 객체에 대햐서 
				switch (method.getName()) {
				
				case "plus":
					
					return a + b;

				case "minus":
					return a - b;
					
			
				
				}
				return 0;//=>return Integer.valueOF(0); 0이 내부적으로 이 문장으로 바뀐다.
				//자바 컴파일러가 프리머타입을 객체로 바꿔주는 조작을  자동으로 한다 : autoboxing, autounboxing
				//autoboxing: 프리머티브 타입을 래퍼 객체에 자동으로 포장해서 리턴
				//래퍼객체에 들어있는 값을 자동으로 꺼내는것: autounboxing
			
			}
		}
		
		
		Class<?> clazz = Calculator.class;//파일확장자가 아닌다. 클래스 또는 인스턴스의 스태틱 변수를 의미한다.(클래스 정보를 가리키는 주소가 들어있다.)
		
		//Calculator 인터페이스를 구현한 클래스를 만들고 그 인스턴스를 생성하여 리턴하낟.
		 Calculator c1 = (Calculator)Proxy.newProxyInstance(//클래스명.메서드?
				 //이 메서드를 실행하면 proxy가 만들어지는가?
				 //프록시의 타입이 캘큘레이터
				 Calculator.class.getClassLoader(),//Calculator클래스에 대한 정보를 얻어온다.
				 new Class[] {Calculator.class},// Class이름의 배열을 생성 하는데 그 
				new MyHandler());//객체인데 클래스로만들었다.
		 
		 System.out.println(c1.plus(10, 20));//c1:레퍼런스
		 System.out.println(c1.minus(10, 20));
		
	}

}

