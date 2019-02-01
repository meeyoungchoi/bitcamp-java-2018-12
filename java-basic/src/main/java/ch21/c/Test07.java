//애플리케이션 예외의 종류: RunTimeException 계열의 예외처리3
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import design_pattern.iterator.ArrayList;

public class Test07 {
	
	public static void main(String[] args) 
		//
		//
		// 다만 그럼에도 메서드 선언부에 지정하는 이유는 
		//이 메서드를 호출하는 개발자에게 이 메서드에서 어떤 예외가 발생하는지 알려주기 위함이다.
		//물론 이번 예제에서 main()에 붙이는 것은 아무 의미가 없다.
		throws RuntimeException {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("홍길동");
		list.add("임꺽정");
		list.add("유관순");
		
		//
		//=>목록에서 인덱스로 지정한 위치의 값을 꺼내준다.
		//=>만약 인덱스가 뮤효하다면 IndexOutOfBoundsException 예외가 발생한다.
		//=>IndexOutOfBoundException은 RuntimeException 계열의 예외 클래스이다.
		//
		
		//
		//1.try ~ catch를 사용하지 않으면 자동으로 호출자에게 보고된다.
		//2.
		//3. throws 문장을 선언할 수 있다.
		//
		//방법2 적용
		//try ~ catch 적용
		//방법3 적용
		//
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));//메서드에 상
		
		
		
			//여기서 예외를 처리했기 때문에 main() 호출자에게 따라ㅗ 보고하지 않는다.
			//System.out.println("실행중 오류 발생");
			
		
		System.out.println("종료");
	
}
}


