//4단계 - 서버 실행 테스트 src4.0
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.eomcs.lms.domain.Member;

public class ServerTest {
	public static void main(String[] args) {




		try (Socket socket = new Socket("localhost",8888);//이거를 먼저 서버로 보내줘서 서버시작 문구가 나오는건가?
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
			System.out.println("서버와 연결되었음"); 

			Member member = new Member();
			member.setNo(1);
			member.setName("홍길동");
			member.setEmail("hong@test.com");
			member.setPassword("1111");
			member.setPhoto("hong.gif");
			member.setTel("1111-11111");

			out.writeObject(member);//어떤 클래스의 인스턴스 값인지 클래스 정보도 함꼐 출력
			out.flush();

			//잘 받았는지 출력?
			System.out.println(in.readObject());
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("클라이언트와의 연결을 끊었음!");

	}
}

