package com.eomcs.lms.handler;

import java.io.BufferedReader;

public class Request {
	BufferedReader in;
	
	public Request(BufferedReader in) {
		this.in = in;
	}
	
	public String getParameter() throws Exception{
		return in.readLine();
	}
}
