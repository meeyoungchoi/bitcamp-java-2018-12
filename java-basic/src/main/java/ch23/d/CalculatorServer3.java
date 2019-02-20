//StateLess server만들기
package ch23.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer3 {
	public static void main(String[] args) {

		try(ServerSocket serverSocket = new ServerSocket(8888)) {

			System.out.println("클라이언트의 연결을 기다리고 있음");

			//StateLess 통신 방법
			//클라이언트 요청이 들어오면 작업을 수행하고 응답을 한다.
			//응답한 후 즉시 연결을 끊는다.
			while (true) {
				try (Socket socket = serverSocket.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream out = new PrintStream(socket.getOutputStream());) {
						System.out.println("클라이언트와 연결되서 요청 처리중");
						
						//먼저 클라이언트가 보낸 세션 ID를 읽는다.
						long sessionId = Integer.parseInt(in.readLine());
					String[] input = in.readLine().split(" ");//input에는 10 + 2와 같은 계산식이 들어간다?


					int a = 0, b = 0, result = 0;
					String op = null;
					try {
						a = Integer.parseInt(input[0]);
						op = input[1];
						b = Integer.parseInt(input[2]);

					} catch (Exception e) {
						System.out.println("식의 형식 바르지 않음");
						out.flush();
						continue;//while문 바로 위로 간다.while(true)로 가서 다음 클라이언트 요청을 받는다.
					}
					
					//클라이언트가 보낸 데이터를 받아서 처리
					switch (op) {
					case "+": result = a + b; break;
					case "-": result = a - b; break;
					case "*": result = a * b; break;
					case "/": result = a / b; break;
					case "%": result = a % b; break;
					default:
						out.printf("%s 연산자를 지원하지 않습니다.\n",op);
						out.flush();
						continue;

					}

					out.printf("결과는 %d\n",result);
					out.flush();
				} catch (Exception e) {
					//
					System.out.println("클라이언트와 통신중 오류 발생");
				}
				System.out.println("클라이언트와 연결 끊음");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
