//Stateful 응용- 클라이언트의 작업 계산결과를 서버에 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer4 {
	public static void main(String[] args) {

		ServerSocket serverSocket = new ServerSocket(8888) 
				
		Socket socket = serverSocket.accept();
		BufferedReader in = new BufferedReader();
	}
}
