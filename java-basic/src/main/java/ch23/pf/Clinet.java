package ch23.pf;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Clinet {
	public static void main(String[] args) {
	
		//connection-oriented : connectionful
		try (Socket socket = new Socket("localhost",8888);
				PrintStream out = new PrintStream(socket.getOutputStream());
				Scanner in = new Scanner(socket.getInputStream())) {
			
			
			System.out.println("서버와 연결됨!");
			
			//먼저 연결을 한 다음에 데이터를 보내고 받을 수 있다.
			out.println("HELLO");
			System.out.println("데이터 보냄!");
			
			String response = in.nextLine();
			System.out.println("데이터 받음!");
			
			System.out.println(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
