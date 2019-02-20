//6단계 - 컬렉션 적용 : 멤버 객체를 담을 컬랙션 준비
package practice;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.eomcs.lms.domain.Member;

public class ServerAppcopy {

	static ArrayList<Member> members = new ArrayList<>();
	static ArrayList<Lessson> lessons = new ArrayList<>();
	static ArrayList<Board> boards = new ArrayList<>();
	
	
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

					ServerAppcopy.in = in;//크라이ㅇ언트와 통신을 수행할 입출력객체
					ServerAppcopy.out = out;

					MemberService .in = in;
					MemberService.out = out;
					
					LessonService.in = in;
					LessonService.out = out;
					
					BoardService.in = in;
					BoardService.out = out;
					
					loop: while (true) {
						String request = in.readUTF();//객체를 보내는 기능도 갖고있다. 1. 명령어를 읽는다.
						System.out.println(request);

						if (request.startsWith("/member")) {//이 문자열이 /member로 시작하는 문자열이라면~
							MemberService.execute(request);//서비스 안에서는 단순비교 하니까 switch case를 사용했다.
						} else if (request.equals("quit")) {
							quit();
							break loop;
						} else {
							out.writeUTF("FAIL");
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

}
