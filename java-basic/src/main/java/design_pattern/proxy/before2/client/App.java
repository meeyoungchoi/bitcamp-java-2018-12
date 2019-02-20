
/*c/s(client/server) 
 *2단계 - 개발자는 원격 서버와 통신을 하여 Calculator 클래스를  간접 사용
 * 
 * app에서 터미널을 통해 server에 있는 calculator에 원격으로 접속한다.
 * calculatorServer가 중간에 통신하는 역할을 한다.
 * 장점:  
 * */
//서버 키고 app을 실행한다.
package design_pattern.proxy.before2.client;

import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		
		Scanner keyboard = new Scanner(System.in);
		//클라이언트 개발자가 원격에 있는 객체를 사용하기 위해서
		//원격 서버와 통신하는 코드를 프로토콜(데이터를 주고 받는 규칙)에 맞춰 직접 작성하였다._
		//
		CalculatorClient calcStub = new CalculatorClient();
		
		while (true) {
			System.out.printf("계산식> (예: 100 + 200) ");
			String input = keyboard.nextLine();
			if (input.equalsIgnoreCase("quit"))
				break;
			
			String[] values = input.split(" ");
			try {
				System.out.println(calcStub.compute(
						Integer.parseInt(values[0]),
						Integer.parseInt(values[2]),
						values[1]));
				
			} catch (Exception e) {
				System.out.println("식 또는 계산 오류: " +e.getMessage());
			}
		}
		keyboard.close();
	}
}
