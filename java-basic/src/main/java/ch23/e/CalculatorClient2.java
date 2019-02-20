//Stateless 응용 - 클라이언트의 계산 결과를 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
 *stateless 응용
 *클라이언트와 서버가 연결되면 연결을 끊기 전까지 작업정보를 계속 유지할수 있다.
 * */

//웹서버가 웹브라우저에게 보관해주는 값
//담번에 요청할때마다 내가 준값 다시보내=>쿠키
public class CalculatorClient2 {
	public static void main(String[] args)  {
		Scanner keyboard = new Scanner(System.in);
		
		long sessionId = 0;
		
		while (true) {
			System.out.print(">");
			String input = keyboard.nextLine();
			if (input.equalsIgnoreCase("quit"))
				break;
			 try (Socket socket = new Socket("localhost",8888);
					 PrintStream out = new PrintStream(socket.getOutputStream());
					 BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()))) {
				 
				 System.out.println("클라이언트와 연결된 서버에게 계산 작업을 요청");
				 
				 out.println(sessionId);
				 out.println(input);
				 out.flush();
				 
				 if (sessionId == 0) {
					 sessionId = Long.parseLong(in.readLine());
					 System.out.printf("발급받은 세션 ID:%d\n",sessionId);
				 }
				 
				 String response = in.readLine();
				 System.out.println(response);
				 
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		}

	}

}

