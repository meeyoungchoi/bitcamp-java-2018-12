//대기열에서 클라이언트 연결정보를 꺼내서 처리한다.
package ch23.a;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4 {
	public static void main(String[] args) throws Exception {
		
		Scanner keyboard = new Scanner(System.in);

		ServerSocket serverSocket = new ServerSocket(8888, 3);
		System.out.println("서버 소켓 생성 완료!");
		System.out.println("클라이언트의 연결을 기다림");
		
		while (true) {
			String input = keyboard.nextLine();
			if (input.equalsIgnoreCase("q"))
				break;
			
			//대기열에서 클라이언트 연결 정보를 꺼내 소켓 객체를 준비한다.
			//대기열은 큐 방식으로 관리하기 때문에 먼저 요청한 클라이언트를 먼저 실행한다.
	//?		Socket socket = serverSocket.accept();//클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
			System.out.println("클라이언트와 연결되었음!!");
			//대기열에서 꺼내는 순간 대기열은 한 칸 빈다.
			//즉 다른 클라이언트 연결을 수용할 수 있다.
		}		 
		
		
	
		serverSocket.close();
		System.out.println("서버 소켓을 닫음");
		
		keyboard.close();
	}

}
