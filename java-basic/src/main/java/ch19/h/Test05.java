//lambda문법 -람다 리턴
package ch19.h;

public class Test05 {
	
	
	static interface Calculator {
		int compute(int a, int b);
	}
	
	public static void main(String[] args) {
		//1.리턴 값은 return 명령을 사용하여 처리한다.
		Calculator c1 = (a,b) -> { return a + b;};
		System.out.println(c1.compute(10, 20));
		
		//2. 한 문장으로 된 표현식(=값을 리턴하는 한 문장의 코드)일 경우 괄호를 생략할 수 있다.
		Calculator c2 = (a,b) -> a - b;
		System.out.println(c2.compute(10, 20));
		
		Calculator c3 = (a,b)-> Math.max(a,b);//둘중에 큰 값을 리턴한다.
		System.out.println(c3.compute(10, 20));
		
		//값을 리턴해야 하는데 람다 문장에서 값을 
		//Calculator c4 = (a,b)-> System.out.println(a + ",", b);;//리턴값이void이므로 컴파일 애러
		//System.out.println(c3.compute(10, 20));
	}
}
