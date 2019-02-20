//2단계
package practice1_4;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest3 {
	public static void main(String[] args) {
		
	
		try (Socket socket = new Socket("localhost",8888); 
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Scanner in = new Scanner(socket.getInputStream())) {
			
		
			System.out.println("서버와 연결되었음");
			
			out.println("Hello");
			out.flush();
			
			System.out.println(in.nextLine());//?무엇을 읽는가
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
