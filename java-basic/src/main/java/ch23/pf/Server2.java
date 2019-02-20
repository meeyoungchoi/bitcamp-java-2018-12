//connectionLess
package ch23.pf;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server2 {
	public static void main(String[] args) {
		
		
		//connectionLess
		//서버와 연결업싱 데이터를 보내고 받을 수 있다.
		//DatagramSocket, DatagramPacket을 사용하여 처리한다.
		try (DatagramSocket socket = new DatagramSocket(8888)) {
		
			//데이터를 받을 버퍼를 준비한다.
			byte[] buf = new byte[8192];
			
			//빈 패킷을 준비한다.
			DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);
			
			//소켓을 이용하여 네트워크로부터 패킷을 받는다.
			socket.receive(emptyPacket);
			System.out.println("데이터 수신 완료!");
			
			//패킷에서 바이트 배열을 꺼낸다.
			String message = new String(emptyPacket.getData(),
					0,
					emptyPacket.getLength(),
					"UTF-8");
			System.out.println(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
