//계산기 서버 만들기
package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer2 {

	
	public static void main(String[] args) {
		try(ServerSocket serverSocket = new ServerSocket(8888)) {
			
			
			try (Socket socket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			OutputStream out = new PrintStream(socket.getOutputStream());) {
			
				String[] input = in.readLine().split(" ");
				//String[] values = input.split(" ");
				
				int a = Integer.parseInt(input[0]);
				String op = input[1];
				int b = Integer.parseInt(input[0]);
				
				System.out.printf("결과는 %d\n",a + b);
				out.flush();
			}
			
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
