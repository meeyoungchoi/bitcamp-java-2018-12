package com.eomcs.lms.handler;

import java.io.PrintWriter;

public class Response {
	PrintWriter out;
	
	public Response(PrintWriter out) {
		this.out = out;
	}
	
	public void println(String message) {
		out.println(message);
		out.flush();
	}
	
	//클라이언트에서 값을 요구한다.
	public void requestValue(String title) {
		out.println(title);
		out.println("!{}!");
		out.flush();
	}
}
