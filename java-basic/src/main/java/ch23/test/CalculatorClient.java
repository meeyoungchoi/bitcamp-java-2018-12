//StateLess 통신방식 
package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * Stateless
 * 서버에 연결한 후 한번 요청하고 응답 받은 후 연결을 끊는다. 
 * 단점: 서버에 요청할 때마다 연결해야 한다.
 * 지속적으로 서버에 연결하는데 실행시간이 소요된다.
 * 장점: 서버에 계속 연결된 상태가 아니기 때문에 서버쪽에서 메모리를 많이 사용하지 않는다.
 * stateful보다 더 많은 클라이언트 요청을 처리할 수 있다.
 * 예
 *http프로토콜, 메신저 등
 * */

public class CalculatorClient {
	public static void main(String[] args) throws Exception {
		
		

		
		Scanner keyboard = new Scanner(System.in);
		
		//서버에서 클라이언트를 구분할 떄 사용할 값
		long sessionId = 0;

		while (true)/*왜 와일믄으로 감싸는가?*/ {
			System.out.print(">");
			String input = keyboard.nextLine();
			if (input.equalsIgnoreCase("quit"))
				break;

			try (	Socket socket = new Socket("localhost",8888);
					PrintStream out = new PrintStream(socket.getOutputStream());//printstream을 사용하기위해서
					BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream())))/*의미*/ {

				System.out.println("클라이언트와 연결된 서버에게 계산 작업을 요청함");
				
				out.println(sessionId);
				out.println(input);
				out.flush();

				if (sessionId == 0 ) {
					//서버에 보낸 세션 ID가 0이면 서버는 새로 세션 ID를 발급하여 보내준다.
					sessionId = Long.parseLong(in.readLine());
					System.out.printf("발급받은 세션 ID: %d\n",sessionId);
				}

				String response = in.readLine();
				System.out.println(response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("서버와 연결 끊음");
		}//while

		keyboard.close();

	}

}

