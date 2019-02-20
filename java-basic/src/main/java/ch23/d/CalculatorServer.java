//StateLess server만들기
package ch23.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(8888)) {

			System.out.println("클라이언트의 연결을 기다리고 있음");
			while (true) {
				try (	Socket socket = serverSocket.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream out = new PrintStream(socket.getOutputStream());) {
					System.out.println("클라이언트와 연결되서 요청 처리중");
					String[] input = in.readLine().split(" ");

					int a = 0, b = 0, result = 0;
					String op = null;//+,-,*,/를 저장할 변수
					try {
						a =Integer.parseInt(input[0]); //input[0]번쨰 배열에 저장도니다.
						op = input[1];
						b = Integer.parseInt(input[2]);
					} catch (Exception e) {
						System.out.println("식의 형식이 바르지 않음");
						out.flush();//식의 형식이 바르지 않은데 out.flush()를 사용하는 이유는 왜인가?
						continue;
					}

					switch (op) {
					case "+": result = a + b; break;
					case "-": result = a - b; break;
					case "*": result = a * b; break;
					case "/": result = a / b; break;
					default:
						out.printf("%s 연산자를 지원하지 않는다.\n",op);
						out.flush();//?
						continue;
					} 

					out.printf("결과는 %d\n",result);
					out.flush();

				} catch (Exception e) {

					System.out.println("클라이언트와 통신중 오류 발생");
				}

				System.out.println("클라잉언트와 연결 끊음");

			}//while문 끝
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
