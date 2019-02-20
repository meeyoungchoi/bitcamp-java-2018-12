//4단계 - 클라이언트와 서버 사이에 클래스의 인스턴스를 주고받는다.
package practice1_4;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp2 {
	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(8888)) {
			System.out.println("서버시작!");
			
			while (true) {
				try (Socket socket = ss.accept();
						ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
					
					System.out.println("클라이언트와 연결되었음");
					
				Object request = in.readObject();
				
				System.out.println(request);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트와의 연결을 끊는다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
