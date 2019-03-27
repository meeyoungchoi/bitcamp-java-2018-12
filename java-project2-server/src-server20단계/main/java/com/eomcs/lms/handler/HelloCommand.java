package com.eomcs.lms.handler;

import com.eomcs.lms.context.Component;
import com.eomcs.lms.context.RequestMapping;

@Component
public class HelloCommand {

	public HelloCommand() {
		
	}

	@RequestMapping("hello")
	public void hello(Response response) {
		response.println("안녕하세요");
	}
}
