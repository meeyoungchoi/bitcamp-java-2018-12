//데이터 주고 받기 - 에코 클라이언트 만들기
package ch23.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
	public static void main(String[] args)  {

		//중간에 실행을 잠깐 멈출 떄 사용하기 위함
		try 		(Scanner keyboard = new Scanner(System.in);
				ServerSocket serverSocket = new ServerSocket(8888)) {

			System.out.println("클라이언트의 연결을 기다리고 있음");

			try (	//
					Socket socket = serverSocket.accept();


					OutputStream out = socket.getOutputStream();
					InputStream in = socket.getInputStream()) {

				System.out.println("서버와 연결되었음!");

				keyboard.nextLine();


				System.out.println("서버 소켓 생성 완료!");
				System.out.println("클라이언트의 연결을 기다림");
				System.out.println("클라이언트와 통신할 입출ㄹ겨 스트림이 준비되었음");

				//Client1과 Server1의 통신 규칙에 따라 순서대로 입출력 해야 한다.
				//왜? 입출력은 blocking모드로 작도아기 때문이다.
				//클라이언트와 서버 간의 데이터를 주고 받는 통신 규칙을 프로토콜이라 한다.
				//에코는 클라이언트에서 한 줄의 문자열을 보낸다.
				//따라서 서버는 한 줄의 문자열을 읽은 후에 응답해야 한다.

				//서버에서 한 줄의 데이터를 읽기 전에는 클라이언트의 println()이 리턴하지 않음을 
				//증명하기 위해 클라이언트가 보낸 데이터를 읽지 않도록 잠시 실행을 중단한다.
				System.out.println("데이터를 읽기 전에 잠깐!");
				keyboard.nextLine();//사용자가 콘솔 창에서 엔터를 칠때까지 리턴하지 않는다.

				//클라이언트 한 줄의 문자열을 보낼 때까지 리턴하지 않는다.
				//한줄의 문자열? 문자열 끝에 줄바꿈 코드(LIneFEed)0x0A를 만날 때까지
				int request = in.read();//blocking모드로 작동한다.
				System.out.println(request);

				//서버가 데이터를 보내지 않으면 클라이언트의 nextLine()은 리턴하지 않는다.
				//이를 확인하기 위해 잠시 실행을 멈춘다.
				System.out.println("데이터를 보내기 전에 잠깐!");
				keyboard.nextLine();

				//클라이언트에게 받은 문자열을 그대로 보낸다.
				//물론 클라이언트가 보낸 데이터를 다 읽을 떄까지 리턴하지 않는다.
				out.write(100 / 3);
				System.out.println("클라이언트에게 데이터를 보냈음");
				keyboard.nextLine();

			}
			System.out.println("클아이언트와의 연결을 끊었음");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("서버 종료!");
	}
}

