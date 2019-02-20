//StateLess응요 - 서버에게 계산 결과 유지하기
package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
	public static void main(String[] args) {

		//클라이언트의 작업 결과를 저장할 맵 객체
		HashMap<Long, Integer> resultMap = new HashMap<>();
		
		try (ServerSocket serverSocket = new ServerSocket(8888)) {
			System.out.println("클라이언트의 연결을 기다리고 있음");
			
			  
		      // 서버의 Stateless 통신 방법에서 클라이언트를 구분하여 각 클라이언트의 계산 결과를 유지하려면?
		      // => 커피숍에서는 고객의 쿠폰 포인트를 어떻게 관리할까?
			while (true) {
				
				try (	Socket socket = serverSocket.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream out = new PrintStream(socket.getOutputStream());) {
					System.out.println("클라이언트와 연결되서 요청 처리중");
					
					long sessionId = Long.parseLong(in.readLine());
					System.out.printf("세션 ID: %d\n",sessionId);
					
					int result = 0;
					boolean isNewSessionId = false;
					
					if (sessionId == 0) {
						//클라이언트에게 세션 ID를 발급한 적이 없다면 새 세션 id를 발급한다.
						sessionId = System.currentTimeMillis();
						isNewSessionId = true;//세션 id를 발급했다고 표시한다.
					} else {
						//클라이언트의 세션 iD로 기존에 저장된 결과 값을 가져온다.
						result = resultMap.get(sessionId);//auto-unboxing
					}
					String[] input = in.readLine().split(" ");

					int b = 0;
					String op = null;//+,-,*,/를 저장할 변수
					
					try {
						//a =Integer.parseInt(input[0]); //input[0]번쨰 배열에 저장도니다.
						op = input[1];
						b = Integer.parseInt(input[2]);
					} catch (Exception e) {
						System.out.println("식의 형식이 바르지 않음");
						out.flush();//식의 형식이 바르지 않은데 out.flush()를 사용하는 이유는 왜인가?
						continue;
					}

					switch (op) {
					case "+": result += b; break;
					case "-": result -= b; break;
					case "*": result *= b; break;
					case "/": result /= b; break;
					default:
						out.printf("%s 연산자를 지원하지 않는다.\n",op);
						out.flush();
						continue;
					} 
					//계산 결과를 세선 id를 사용해서 서버에 저장한다.
					resultMap.put(sessionId, result);
					
					//세션 ID를 새로 발급했다면 클라이언트에게 알려준다.
					if (isNewSessionId) {
						out.println(sessionId);
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
