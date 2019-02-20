//계산기 서버 만들기 - 1단계 : 단순히 클라이언트 요청에 응답하기
//2. 
//3.연산자 처리
//4/
//5. 클라이언트에서 종료하기 전까지는 계속 연결된 상태로 
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
				try {
				new CalculatorProcessor(serverSocket.accept()).execute();
					} catch (Exception e) {
						System.out.println("클라이언트와 통신 중에 올  발생");
						e.printStackTrace();
						
					}
				
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	