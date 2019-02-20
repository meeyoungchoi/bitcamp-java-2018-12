//StateLESS 응용- 클라이언트의 작업 계산결과를 서버에 유지하기



package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer2 {
	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(8888)) {
			System.out.println("클라이언트의 연결을 기다리고 있음");
		}
		
		while (true) {
		try (Socket socket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
				PrintStream out = new PrintStream(socket.getOutputStream());) {
			
			
			System.out.println("클라이언트와 연결되서 요청 처리");
			
			long sessionId = Long.parseLong(in.readLine());
			System.out.printf("세션 ID:%d\n",sessionId);
			
			int result = 0;
			boolean isNewSessionId = false;
			
			if (sessionId == 0) {
				sessionId = System.currentTimeMillis();
				isNewSessionId = true;
			} else  {
				result = reslutMap.get(sessionId);
				
			}
			String[] input = in.readLine().split(" ");
			int b = 0;
			String op = null;
			
			try {
				op = input[1];
				b = Integer.parseInt(input[2]);
			} catch (Exception e) {
				System.out.println("식의 형식이 바르지 않다.");
				out.flush();
				continue;
			}
			
			switch (op) {
			case "+": result += b; break;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}//while끝
	} 
}

















////클라이언트의 작업 결과를 저장할 맵객체
//HashMap<Long,Integer> resultMap = new HashMap<>();
//
//try (ServerSocket serverSocket = new ServerSocket(8888)) {
//	System.out.println("서버 실행 중...");
//
//	while (true) {
//
//		try (Socket socket = serverSocket.accept();
//				BufferedReader in = new BufferedReader(
//						new InputStreamReader(socket.getInputStream()));
//				PrintStream out = new PrintStream(socket.getOutputStream());) {
//
//			System.out.println("클라이언트와 연결됨");
//
//
//
//			while (true) {
//				String request = in.readLine();//request?
//				System.out.println("요청 처리함");
//
//				/*if (request.equalsIgnoreCase("quit")) {
//		out.printf("최종 계산 결과는 %d입니다.\n", result);
//		out.flush();
//		break;
//	}*/
//				long sessionId = Integer.parseInt(in.readLine());
//				System.out.printf("세션ID: %d\n",sessionId);
//				
//				int result = 0;
//				boolean isNewSessionId = true;
//				
//				if (sessionId == 0) {
//					//클라이언트에게 세션 Id를 발급한 적이 없다면(처음 방문고객), 새 세션  ID를 발급한다.
//					sessionId = Long.parseLong(in.readLine());
//					isNewSessionId = true;//세션 Id를 새로 발급 했다고 표시한다.
//				} else {
//					//클라이언트에게	
//					result = resultMap.get(sessionId);//auto-unboxing =>객체안에 들어있는 값을 뽑아낸다.Integer.intValue();
//				}
//
//
//				String[] input = request.split(" ");
//
//				int b = 0;
//				String op = null;
//
//				try {
//					op = input[0];
//					b = Integer.parseInt(input[1]);
//				} catch (Exception e) {
//					out.println("식의 형식이 바르지 않습니다.");
//					
//					out.flush();
//					continue;
//				}
//
//				switch(op) {
//				case "+": result += b; break;
//				case "-": result -= b; break;
//				case "*": result *= b; break;
//				case "/": result /= b; break;
//				case "%": result %= b; break;
//				default:
//					out.printf("%s 연산자를 지원하기 않습니다.\n",op);
//					out.flush();
//					continue;
//				}
//
//				//계산결과를 세션 id를 사용해서 서버에 저장한다.
//				resultMap.put(sessionId, result);
//				
//				//세션ID를 새로 발급했다면 클라이언틍에게 보내준다.
//				if (isNewSessionId) {
//					out.println(sessionId);
//				}
//				out.printf("결과는 %d입니다.\n",result);
//				out.println(sessionId);
//				out.flush();
//			}//while
//		} catch (Exception e) {
//			System.out.println("클라이언트와 통신 중 오류 발생!");
//		}
//		System.out.println("클라이언트와 연결 끊음");
//
//	}//while 끝
//}catch (Exception e) {
//	e.printStackTrace();
//}