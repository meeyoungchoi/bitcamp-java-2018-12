package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CalculatorProcessor {
	Socket socket;
	
	public CalculatorProcessor(Socket socket) throws Exception {
		this.socket = socket;
		this.in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		this.out = new PrintStream(socket.getOutputStream()); 
	}
	
	public void execute() throws Exception {
		try (Socket socket = this.socket;
				BufferedREader in = this.in;
				PrintStream out = this.out){
			
			
			sendGreeting(out);


			while (true) {
				String request = in.readLine();
				if (isQuit(request, out))
					break;
				
				calculate(request, out);
				
		} 
	}
}

	static boolean inQuit(String request, PrintStream out) {
		if (request.equalsIgnoreCase("quit")) {
			out.println("안녕히 가세요!");
			out.flush();
			return true;
		}
		return false;
	}