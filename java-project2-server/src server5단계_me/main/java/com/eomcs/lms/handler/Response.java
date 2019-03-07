package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;

public class Response {
	BufferedReader in;
	PrintWriter out;
	
	public Response(BufferedReader in, PrintWriter out) {
		this.out = out;
	}
	
	public void println(String message) {//생성자에서 받은 printWrite를 사용해서 출력을 대신한다.
		out.println(message);
		out.flush();
	}
	
	//클라이언트에서 값을 요구한다.
	public String requestString(String title) throws Exception {//클라이언트를 캡슐화시켰다.
		out.println(title);
		out.println("!{}!");
		out.flush();
		//값을 요구하는 출력의 경우
		return in.readLine();
	}
	
	public int requestInt(String title) throws Exception {
		return Integer.parseInt(this.requestString(title));
	}
	
	public Date requestDate(String title) throws Exception {
		return Date.valueOf(this.requestString(title));
	}
	
	
}
