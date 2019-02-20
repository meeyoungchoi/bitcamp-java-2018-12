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
				processSocket(serverSocket.accept());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void processRequest(Socket socket) {
		BufferedReader in = null;
		PrintStream out = null;

		try {
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream()); 

			sendGreeting(out);


			while (true) {
				String request = in.readLine();
				if (isQuit(request, out))
					break;
				
				calculate(request, out);
				
		} finally {
			try {in.close();} catch (Exception e) {}
			try {out.close();} catch (Exception e) {}
			try {socket.close();} catch (Exception e) {}

		}
	}
	static void sendGreeting(PrintStream out) {
		System.out.println("계산기 서버에 오신걸 환영합니다.");
		out.println("계산식을 입력하세요!");
		out.println("예) 23 + 7");
		out.println();
	}
	
	static void Calculate(String request, PrintStream out) {
		
		String request = in.readLine();
		if (request.equalsIgnoreCase("quit")) {
			out.println("안녕히 가세요!");
			out.flush();
			break;
		}

		String[] input = request.split(" ");

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
			return;
			}

		out.printf("결과는 %d\n",result);
		out.flush();
	}	 catch (Exception e) {
	try {
		out.println("식의 형식이 잘못되었습니다.");
		out.flush();
	} catch (Exception e2) {}
}
		static boolean inQuit(String request, PrintStream out) {
			if (request.equalsIgnoreCase("quit")) {
				out.println("안녕히 가세요!");
				out.flush();
				return true;
			}
			return false;
		}
	}
}
