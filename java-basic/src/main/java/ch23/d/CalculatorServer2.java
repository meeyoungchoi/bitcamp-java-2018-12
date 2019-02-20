//StateLess server만들기
package ch23.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer2 {
	public static void main(String[] args) {

		try(ServerSocket serverSocket = new ServerSocket(8888)) {

			System.out.println("클라이언트의 연결을 기다리고 있음");

			//서버의 Stateful 통신 방법
			//먼저 클라이언트와 연결된 후 클라이언트 요청을 처리한다.
			//클라이언트에서 연결을 끊기 전까지는 계속 연결을 유지한다.
			//
			while (true) {
				try (Socket socket = serverSocket.accept();
						BufferedReader in = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						PrintStream out = new PrintStream(socket.getOutputStream());) {

					System.out.println("클라이언트와 연결됨");

					while (true) {
						String request = in.readLine();
						System.out.println("요청 처리함");
						if (request.equalsIgnoreCase("quit")) {//quitㅇ르 해야 비로서  클라이언트와 연결을 끊는다.
							out.println("종료합니다.");
							out.flush();
							break;
						}
						String[] input = in.readLine().split(" ");

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
					}
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
