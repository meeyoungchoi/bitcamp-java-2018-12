package com.eomcs.lms.handler;

public class HelloCommand extends AbstractCommand {

	public HelloCommand() {
		
	}

	@Override
	public void execute(Response response) {
		response.println("안녕하세요");
	}
}
