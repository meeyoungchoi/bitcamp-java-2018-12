//애플리케이션 예외의 종류: Exception 계열의 예외처리
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
	
		// 1.exception 계열의 예외 방법
		//1.try ~ catch 예외받기
		//
		//
		//
		//
		//2.호출자에게 예외 처리를 떠넘기기
		//void 메서드() throws 예외클래스명, 
		//
		//
		//
		try {
			Scanner keyboard = new Scanner(System.in);
			Class<?> clazz = Class.forName("ch21.c.PlusCommand2");
			Constructor<?> constructor = clazz.getConstructor(Scanner.class);
			Command command = (Command) constructor.newInstance(new Scanner(System.in));
			command.execute();
			} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스를 찾지 못했습니다.");
			
		}  catch (NoSuchMethodException e) {
		//예외를 발생시키는방법
		//
		//
		System.out.println("해당 생성자를 찾지 못했습니다.");
	} catch (ReflectiveOperationException e) {
		System.out.println("기타 예외 발생");
	} 
		System.out.println("종료");
		
	}
}
