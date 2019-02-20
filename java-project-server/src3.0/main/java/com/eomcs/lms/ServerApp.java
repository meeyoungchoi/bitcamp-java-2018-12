//3단계 - 클라이언트가 보낸 데이터를 그대로 출력한다.src3.0
package com.eomcs.lms;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {
	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(8888)){//포트번호를 받을때도 in으로 받는가?
			System.out.println("서버 시작!");
			
			while (true) {
				try (Socket socket = ss.accept();
						PrintStream out = new PrintStream(socket.getOutputStream());
						Scanner in = new Scanner(socket.getInputStream())) {
						System.out.println("클라이언트와 연결되었음"); //이거 다음에 어떤순서?
						
						String request = in.nextLine();
						out.println(request);
						out.flush();
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				System.out.println("클라이언트와의 연결을 끊었음!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
