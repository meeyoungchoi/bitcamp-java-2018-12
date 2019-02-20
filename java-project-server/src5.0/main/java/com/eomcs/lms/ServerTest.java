//4단계 - 서버 실행 테스트
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
			
			add(new Member(1, "홍길동"));//얘를 서버에 보내면 서버에서 members.add(Member)in.readObject()로 전달되는건가?
			//new Member는 
			add(new Member(2, "임꺽정"));//?

			list();
			/*out.writeUTF("add");//명령어를 먼저 보내고
			out.writeObject(new Member(2, "임꺽정"));// 객체를 보내서 서버에저장
			out.flush();
			System.out.println("in.readUTF()");
			 */
			
			
			//System.out.println(in.readUTF());//서버에서 문자열을 줄때까지 기다린다. 한없이 기다리게되므로 없어도 된다.

			out.writeUTF("okok");
			out.flush();
			System.out.println(in.readUTF());

			quit();
			//System.out.println(in.readUTF());
			/*
			Member member = new Member();
			member.setNo(1);
			member.setName("홍길동");
			member.setEmail("hong@test.com");
			member.setPassword("1111");
			member.setPhoto("hong.gif");
			member.setTel("1111-11111");

			out.writeObject(member);//어떤 클래스의 인스턴스 값인지 클래스 정보도 함꼐 출력
			out.flush();

			//잘 받았는지 출력
			System.out.println(in.readObject());*/
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("서버와의 연결을 끊었음!");

	}

	static void add(Member member) throws Exception {
		out.writeUTF("add");
		out.writeObject(member);
		out.flush();
		System.out.println(in.readUTF());
	}

	static void list() throws Exception {
		out.writeUTF("list");
		out.flush();
		@SuppressWarnings("unchecked")
		//서버에 저장된 객체 목록을 받아서 출력
		List<Member> members  = (List<Member>) in.readObject();//얘가 리턴한다 리스트를
		for (Member m : members) {
			System.out.println(m);
		}
	}

	static void quit() throws Exception {
		out.writeUTF("quit");
		out.flush();
	}
}

