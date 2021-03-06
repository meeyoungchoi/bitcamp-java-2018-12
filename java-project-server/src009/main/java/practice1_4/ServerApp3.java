//2단계
package practice1_4;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp3 {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(8888)) {
			System.out.println("서버 시작");
			
			while (true) {
				try (Socket socket = serverSocket.accept();
						Scanner in = new Scanner(socket.getInputStream());
						PrintWriter out = new PrintWriter(socket.getOutputStream())) {
					System.out.println("클라이언트와 연결되었음");
					
					String request = in.nextLine();
					out.println(request);
					out.flush();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트와의 연결을 끊었음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
