//예외 처리하기 - catch 블록 - 여러개의 예외가 발생할때 , 멀티 
package ch21.b;


import java.util.HashMap;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in);
		
		HashMap<String, Command> commandMap = new HashMap<>();
		commandMap.put("plus", new PlusCommand(keyboard));
		//commandMap.put("plus", c1);//commandMap.put("plus", new PlusCommand());
		
		
		System.out.print("명령> ");
		String input = keyboard.nextLine();
	
		//예외 처리 문법을 적용하면, 예외가 발생하더라도
		try {
			Command command = commandMap.get(input);
			command.execute();
			
			System.out.println("실행완료");
			
			//
			//각 예외		
			//예외를 한개만 받으면 시스템이 멈출수 있다.
		} catch (NullPointerException e) {
			System.out.println("해당 명령이 존재하지 않스빈다.");
			
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
			
		}
		System.out.println("실행완료");
		keyboard.close();
		
	}
}
