package ch23.pg;

import java.io.PrintStream;
import java.net.Socket;

public class HttpClient {
	public static void main(String[] args) {
		//http프로토콜
		//웹서버와 웹브라우저 사이의 통신 규칙이다.
		//Stateless 방식으로 동작한다.
		
		try (Socket socket = new Socket("www.skhynix.com",80);
				PrintStream out = new PrintStream(socket.getOutputStream())) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
