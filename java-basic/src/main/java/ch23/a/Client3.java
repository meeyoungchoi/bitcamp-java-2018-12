//타임아웃 시간 설정하기
package ch23.a;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client3 {

	//예제 테스트
	//Server2를 먼저 실행시킨 다음에 이 클래스를 여러번 실행하라
	//
	public static void main(String[] args) throws Exception {
		//실행을 잠시 중단시키기 위해 사용
		Scanner keyboard = new Scanner(System.in);
		
		//1.소켓을 먼저 생성한 후 서버와의 연결을 시도한다.
		Socket socket = new Socket();
		System.out.println("소켓 생성됨");

		//2. 연결할 서버의 주소를 준비한다.
		SocketAddress sockerAddress = new InetSocketAddress("localhost",8888);
		
		//3. 서버와의 연결을 시도한다.
		//타임아웃으로 지정된 시간안에 서버와 연결되지 않으면 즉시 예외를 발생시킨다.
		//
		System.out.println("서버와 연결중 ...");
		socket.connect(sockerAddress, 5000);//타임아웃은 밀리초이다.(mili-seconds)
		System.out.println("서버와 연결 되었음!!");
		
		
		keyboard.nextLine(); //사용자가 엔터를 칠 때까지 다음 코드로 이동하지 않는다.
		//엔터를 치면 연결이 끊긴다.
		socket.close();
		System.out.println("서버와의 연결이 끊어졌음");
		//대기얼의 크기에 따라 연결되는 클라이언트 수의 제한을 확인하기 위해 
		//여러 개의 클라이언트를 실행하라!
		
		keyboard.close();
	}

}
