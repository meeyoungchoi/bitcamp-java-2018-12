//계산기 서버 만들기 - 1단계 : 단순히 클라이언트 요청에 응답하기
//2. 
//3.연산자 처리
package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
	public static void main(String[] args) {
		
		try(ServerSocket serverSocket = new ServerSocket(8888)) {
			
			System.out.println("클라이언트의 연결을 기다리고 있음");
			while (true) {
				Socket socket = null;
				BufferedReader in = null;
				PrintStream out = null;
				
				try {
						socket = serverSocket.accept();
						in = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						out = new PrintStream(socket.getOutputStream()); {
			
				String[] input = in.readLine().split(" ");
				//String[] values = input.split(" ");
				
				int a = Integer.parseInt(input[0]);
				String op = input[1];
				int b = Integer.parseInt(input[2]);
				int result = 0;
				
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
				try {
					out.println("식의 형식이 잘못되었습니다.");
					out.flush();
				} catch (Exception e2) {}
				
			} finally {
				try {in.close();} catch (Exception e) {}
				try {out.close();} catch (Exception e) {}
				try {socket.close();} catch (Exception e) {}
				socket.close();
			}
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
