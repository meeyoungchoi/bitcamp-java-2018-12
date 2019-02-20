//4단계 - 클라이언트와 서버 사이에 클래스의 인스턴스를 주고받는다.src4.0
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.eomcs.lms.domain.Member;

public class ServerApp {
	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(8888)){
			System.out.println("서버 시작!");
			
			while (true) {
				try (Socket socket = ss.accept();
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
/*객체를 다시출력*/						ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
					
						System.out.println("클라이언트와 연결되었음");
						
						Member member = (Member) in.readObject();
						
						//클라이언트에서 serialize해서 보내온 Member객체의 내용을 출력하라
						System.out.println(member);
					
						out.writeObject(member);//얘는 어떤 일을 하는가?
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				System.out.println("클라이언트와의 연결을 끊었음!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
