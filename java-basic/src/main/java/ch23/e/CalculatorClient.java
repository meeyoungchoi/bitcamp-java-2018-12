//StateLess 응용 - 서버에서 계산결과 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * Stateless는 응답을 받은 후에 연결을 끊는다.
 * 다시 요청할 때는 서버와 연결을 다시 한다.
 * 서버 쪽에서는 어떻게 클라이언트를 구분하여 작업 결과를 유지할 것인가?
 * */

public class CalculatorClient {
	public static void main(String[] args) throws Exception {

		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("> ");
			String input = keyboard.nextLine();
			if (input.equalsIgnoreCase("quit"))
				break;
			
			try (Socket socket = new Socket("localhost", 8888);
					PrintStream out = new PrintStream(socket.getOutputStream());
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()))) {
				
				System.out.println("서버와 연결됨 ! 서버에게 계산 작업을 요청함");
				
				
			
				
				out.println(input);//input?
				out.flush();
				
				String response = in.readLine();//response?
				System.out.println(response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("서버와 연결 끊음!");
		}//while
		
		keyboard.close();
	
	}
}



