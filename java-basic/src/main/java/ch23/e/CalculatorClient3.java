//Stateful 응용 - 클라이언트의 계산 결과를 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
 *stateful 응용
 *클라이언트와 서버가 연결되면 연결을 끊기 전까지 작업정보를 계속 유지할수 있다.
 * */

public class CalculatorClient3 {
	public static void main(String[] args) throws Exception {

		Scanner keyboard = new Scanner(System.in);

		//
		long sessionId = 0;
		//계산 요청을 할때 연산자와 값만 넘긴다.
		//예) + 2
		//예) / 3
		//
		try (Socket socket = new Socket("localhost",8888);
				PrintStream out = new PrintStream(socket.getOutputStream());
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()))) {

			System.out.println("서버와 연결됨");
			
			while (true) {
				System.out.print(">");
				String input = keyboard.nextLine();

				//
				out.println(sessionId);
				long sessionId = Integer.parseInt(in.readLine());
				System.out.printf("세션Id: %d\n",);
				out.println(input);//사용자가 입력한 값을 보낸다.
				out.flush();

				System.out.println("서버에게 계산 작업을 요청함");
				
				String response = in.readLine();
				System.out.println(response);//서버에 quit을 보내고 응답을 받는다.
				
				if (input.equalsIgnoreCase("quit"))//만약에 종료한다면
					break;
			}//while
			
			System.out.println("서버와 연결 끊음");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		keyboard.close();
	}
}



