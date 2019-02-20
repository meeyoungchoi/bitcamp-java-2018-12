//httpserver 만들기 -웹서버는 stateless 방식으로 동작한다.
package ch23.g;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {
	public static void main(String[] args) {

		//http응답규칙
		//----------------------------------------------------------------
		//[프로토콜]/[버전] [실행결과코드] [실행결과문구(간단한 메시지)](CRLF)
		//content-type: [mind type](CRLF)
		//....
		//(CRLF)
		//서버가 클라이언트에게 보내는 콘텐트
		//-------------------------------------------------------------------

		try (ServerSocket ss = new ServerSocket(8888)) {
			System.out.println("서버 실행중 .....");
			
			while (true) {
				try (Socket socket = ss.accept();
						PrintStream out = new PrintStream(socket.getOutputStream());
						Scanner in = new Scanner(socket.getInputStream())) {
					
					while (true) { 
					String request = in.nextLine();//읽은 데이터를 받음
					System.out.println(request);
					if (request.length() == 0)//빈줄을 만날때까지 읽는다.
						break;
					}
					
					out.println("HTTP/1.1 200 ok");
					out.println("Content-Type: text/html;charset=UTF-8");
					out.println();
					out.println("<html><body><h1>오호라!! 안녕하세요!</h1></body></html>");
					out.flush();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
