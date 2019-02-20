//2단계
package practice1_4;

import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost",8888)) {
			System.out.println("서버와 연결되었음");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
