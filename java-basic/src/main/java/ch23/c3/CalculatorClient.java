//클라이언트
package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//실행 예:
/*
 * 클라이언트가 계산기 서버에 접속한 후 
 * 계산기 서버에 오신걸 환영합니다.<===서버의 응답
 * 계산식을 입력하세요
 * 예) 23 + 7 <== 서버의 응답
 * 
 *  >23 + 7<==사용자의 입력 '>'문자는 클라이언트에서 출력한다.
 *  결과는 30입니다.<== 서버의 응답
 *  >23 ^ 7 <==사용자의 입력 '>' 문자는 클라이언트에서 출력한다.
 *  ^연산자를 지원하지 않습니다.. <==서버의 응답
 *  >ok + yes<==사용자의 응답
 *  식의 형식이 잘못되었습니다.<==서버의 응답
 *  
 *  >quit <==사용자의 입력 '>'문자는 클라이언트에서 출력한다.
 *  안녕히 가세요 <== 서버의 응답
 * 
 * */

public class CalculatorClient {

	
	public static void main(String[] args) throws Exception {

		try (Scanner keyboard = new Scanner(System.in);
				Socket socket = new Socket("localhost",8888);
				PrintStream out = new PrintStream(socket.getOutputStream());
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()))) {
							
							System.out.print(">");
							String input = keyboard.nextLine();
							
							out.println(input);
							out.println("10 + 30");
							out.flush();
							
							String response = in.readLine();
							System.out.println(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	}
	


