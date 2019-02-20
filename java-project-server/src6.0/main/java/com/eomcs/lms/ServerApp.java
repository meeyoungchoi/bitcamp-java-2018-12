//6단계 - 컬렉션 적용 : 멤버 객체를 담을 컬랙션 준비 src6.0
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.eomcs.lms.domain.Member;

public class ServerApp {

	static ArrayList<Member> members = new ArrayList<>();
	static ObjectInputStream in;
	static ObjectOutputStream out;

	public static void main(String[] args) {



		try (ServerSocket ss = new ServerSocket(8888)){
			System.out.println("서버 시작!");

			while (true) {


				try (Socket socket = ss.accept();
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

					System.out.println("클라이언트와 연결되었음");
					members.clear();
					ServerApp.in = in;//크라이ㅇ언트와 통신을 수행할 입출력객체
					ServerApp.out = out;

					/*라벨을 붙인다. 중괄로흫를 쓰지않으면 한개의 문장에만 라벨이 붙는다.*/
					loop: while (true) {
						String request = in.readUTF();//객체를 보내는 기능도 갖고있다. 1. 명령어를 읽는다.
						System.out.println(request);

						switch (request) {
						case "quit":
							quit();
							break loop;
						case "/member/add"://명령어를 받고
							add();
							break;
						case "/member/list":
							list();
							break;
						case "/member/update":
							update();
							break;
						case "/member/delete":
							delete();
							break;
						case "/member/detail":
							detail();
							break;
						default:
							out.writeUTF("이 명령을 처리할 수 없음");

						}
						out.flush();
					}
					/*
						Member member = (Member) in.readObject();
						//클라이언트에서 serialize해서 보내온 Member객체의 내용을 출력하라
						System.out.println(member);
						//
						out.writeObject(member);
						out.flush();*/

				} catch (Exception e) {
					e.printStackTrace();

				}
				System.out.println("클라이언트와의 연결을 끊었음!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	static void quit() throws Exception {
		out.writeUTF("종료함");
		out.flush();
	}

	static void add() throws Exception{
		    members.add((Member)in.readObject());
		    out.writeUTF("OK");
	}

	static void list() throws Exception {
		/*out.writeUTF("/member/list");//응답결과로 어레이리스트를 보낸다.

		String status = in.readUTF();

		if (status.equals("ok"))
			System.out.println("데이터 성공");
		System.out.println("데이터 실패");*/
		  out.writeUTF("OK");
		  out.writeObject(members);//실행과정?
		
	}

	static void detail() throws Exception {
		/*out.writeUTF("/member/detail");
		out.writeInt(no);
		out.flush();

		String status = in.readUTF();

		if (status.equals("ok")) {
			System.out.println("데이터 가져오기 실패");
		}

		Member member = (Member) in.readObject();
		System.out.println(member);*/
		
		 int no = in.readInt();
		    
		    for (Member m : members) {
		      if (m.getNo() == no) {
		        out.writeUTF("OK");
		        out.writeObject(m);
		        return;
		      }
		    }
		    
		    out.writeUTF("FAIL");

	}

	static void update() throws Exception {
		/*out.writeUTF("/member/update");
		out.writeObject(member);
		out.flush();

		String status = in.readUTF();

		if (status.equals("ok")) 
			System.out.println("데이터 변경 성공");
		else 
			System.out.println("데이터 변경 실패");


		System.out.println(in.readUTF());*/
	    Member member = (Member) in.readObject();
	    
	    int index = 0;
	    for (Member m : members) {
	      if (m.getNo() == member.getNo()) {
	        members.set(index, member);
	        out.writeUTF("OK");
	        return;
	      }
	      index++;
	    }
	    
	    out.writeUTF("FAIL");
	}

	static void delete() throws Exception {
		/*out.writeUTF("quit");
		out.writeInt(no);
		out.flush();

		String status = in.readUTF();

		if (status.equals("ok")) 
			System.out.println("데이터 삭제 성공");
		else 
			System.out.println("데이터 삭제 실패");



		System.out.println(in.readUTF());*/
		
		int no = in.readInt();
		
		int index = 0;
		for (Member m : members) {
			if (m.getNo() == no) {
				members.remove(index);
				out.writeUTF("OK");
				return;
			}
			index++;
		}
		out.writeUTF("FAIL");
	}
}
