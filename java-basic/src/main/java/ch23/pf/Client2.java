package ch23.pf;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {
	public static void main(String[] args) {
		
		try (DatagramSocket socket = new DatagramSocket()) {
			
			for (int i = 0; i < 100; i++) {
				//format 문자열을 만들어서 리턴한다.
				byte[] bytes = String.format("HELLO-%d", i).getBytes("UTF-8");
				//보낼데이터와 상대편이 받을 주소를 패킷에 담는다.
				DatagramPacket packet = new DatagramPacket(
						bytes,
						bytes.length,
						InetAddress.getByName("localhost"),
						8888);
				
				//소켓을 이용하여 패킷을 네트워크로 내 보낸다.
				socket.send(packet);
				System.out.println(i + " - 데이터 전송 완료!(단 상대편이 해당 패킷을 받았는지는 보장 못함)");
				Thread.currentThread().sleep(500);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
