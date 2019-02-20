//connectionOriented vs connectionless
package ch23.f;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		//connectionless : 비연결지향
		//서버와 연결없이 데이터를 보내고 받을 수 있다.
		//DatagramSocket, DatagramPacket을 사용하여 처리한다.
		//예) 편지, ping 등
		//응용) 모니터링 프로그램에서 많이 사용한다.

		//데이터 송수신을 담당할 소켓을 먼저 준비한다.
		try (DatagramSocket socket = new DatagramSocket()) {

			for (int i = 0; i < 100; i++) {
				//보낼데이터와 상대편(받는이) 주소를 패킷에 담는다.
				byte[] bytes = String.format("HELLO-%d", i).getBytes("UTF-8");//format:문자열을 만들어서 리턴한다.?
				DatagramPacket packet = new DatagramPacket(
						//"HELLO".getBytes("UTF-8")/*UTF8형식(인고딩)의 바이트배열을 꺼낸다*/,
						bytes,//
						bytes.length,//
						InetAddress.getByName("localhost"),//
						8888//
						);


				//소켓을 이용하여 패킷을 네트워크로 내 보낸다.
				socket.send(packet);
				System.out.println(i + " - 데이터 전송 완료!(단 상태편이 해당 패킷을 받았는지는 보장 못함)");
				Thread.currentThread().sleep(500);//작업을 수행하는 거를 0.5초마다 쉬게한다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
