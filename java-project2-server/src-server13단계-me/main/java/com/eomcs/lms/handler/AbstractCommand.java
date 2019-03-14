package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.util.DataSource;

// 추상 클래스의 목적?
// => 서브 클래스에게 필드나 메서드를 상속해 주는 용도.
// => 직접 사용하지 못한다.
// 
public abstract class AbstractCommand implements Command {

	
	@Override
	public void execute(BufferedReader in, PrintWriter out)  {//try블럭을 벗어날때 close가 자동으로 일어난다.
		//여기에 thrwos exception을 하면 Exception Exception is not compatible with throws clause in Command.execute(BufferedReader, PrintWriter)
		//클라이언트 요청을 처리한 후 커넥션을 자동으로 닫도록
		//try-with-resources 블록에 Connection 레퍼런스를 선언한다.
		//커넥션을 닫으면 안된다.
		try {
			execute(new Response(in, out));
			//현재 스레드에 보관된 connection 객체를 꺼낸다.
			//그리고 그 커낵션 객체를 통해 수행했던 모든 데이터 변경 작업을 커밋한다.
			//커밋도 안한다.
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public void execute(Response response) throws Exception {
		// 서브 클래스에서 오버라이딩 해야할 메서드이다.
		// 그러나 서브 클래스가 반드시 오버라이딩 하도록 강요하지 않기 위해 추상 메서드로 선언하지 않는다.
		// 왜? 서브 클래스는 Command의 execute(BufferedReader, PrintWriter)를 
		// 오버라이딩 할지도 모르기 때문이다. 
		// 
	}
}
