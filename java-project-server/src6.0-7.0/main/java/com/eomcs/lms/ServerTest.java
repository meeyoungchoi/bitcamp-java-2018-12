//6단계 - 서버 실행 테스트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.eomcs.lms.domain.Member;

public class ServerTest {

	static ObjectOutputStream out;
	static ObjectInputStream in;

	public static void main(String[] args) {

		try (Socket socket = new Socket("localhost",8888);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
			System.out.println("서버와 연결되었음"); 
			ServerTest.in = in;
			ServerTest.out = out;

			//MemberTest.in = in;
			//MemberTest.out = out;
			//MemberTest t1 = new MemberTest(out, in);
			new MemberTest(out, in).test();
			System.out.println("----------------------------------------------------------------");
			new LessonTest(out, in).test();
			System.out.println("----------------------------------------------------------------");
			new BoardTest(out, in).test();
			//t1.test();
			//MemberTest.test();
			//testMember();

			quit();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("서버와의 연결을 끊었음!");

	}

	static void testMember() throws Exception {
	

		
	}
	
	
	static void quit() throws Exception {
		out.writeUTF("종료함");
		out.flush();
		System.out.println(in.readUTF());
	}
}

