//데이터 주고 받기 - 에코 서버 만들기
package ch23.b;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
	public static void main(String[] args)  {

		//중간에 실행을 잠깐 멈출 떄 사용하기 위함
		try (Scanner keyboard = new Scanner(System.in);
				ServerSocket serverSocket = new ServerSocket(8888)) {

			System.out.println("클라이언트의 연결을 기다리고 있음");

			try (	//
					Socket socket = serverSocket.accept();
					PrintWriter out = new PrintWriter(socket.getOutputStream());
					Scanner in = new Scanner(socket.getInputStream())) {

				System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음");
				System.out.println("서버와 연결되었음!");
				System.out.println("서버 소켓 생성 완료!");
				System.out.println("클라이언트의 연결을 기다림");
				System.out.println("클라이언트와 통신할 입출ㄹ겨 스트림이 준비되었음");

				keyboard.nextLine();
				
		      System.out.print("데이터를 읽기 전에 잠깐!");

				
				String request = in.nextLine();//blocking모드로 작동한다.
				System.out.println(request);
				


				System.out.println("데이터를 보내기 전에 잠깐!");
				keyboard.nextLine();

				out.write("**" + request+ "**");
				out.flush();
				System.out.println("클라이언트에게 데이터를 보냈음");
			

			}
			System.out.println("클아이언트와의 연결을 끊었음");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("서버 종료!");
	}
}

