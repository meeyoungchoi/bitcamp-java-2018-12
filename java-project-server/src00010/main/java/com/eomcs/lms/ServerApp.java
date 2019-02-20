//10단계 - 클라이언트 요청을 처리하는 서비스 클래스를 별도의 패키지로 분류하기
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

public class ServerApp {

	static ArrayList<Member> members = new ArrayList<>();

	static ObjectInputStream in;
	static ObjectOutputStream out;

	static MemberService memberService = null;
	static LessonService lessonService = null;
	static BoardService boardService = null;

	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(8888)) {
			System.out.println("서버 시작!");

			//MemberService memberService = null;
			//LessonService lessonService = null;
			//BoardService boardService = null;

			try {
				//memberService = new MemberService(in, out);
				memberService = new MemberService();
				memberService.loadData("member.bin");
				// lessonService = new LessonService(in, out);
				// boardService = new BoardService(in, out, "board.bin");

			} catch (Exception e) {
				System.out.println("회원 데이터 로딩 중 오류 발생!");
				//e.printStackTrace();//오류발생원인 출력
			} 


			try {
				//memberService = new MemberService(in, out);
				//lessonService = new LessonService(in, out);
				lessonService = new LessonService();
				lessonService.loadData("lesson.bin");
				// boardService = new BoardService(in, out, "board.bin");

			} catch (Exception e) {
				System.out.println("수업 데이터 로딩 중 오류 발생!");
				//e.printStackTrace();//오류발생원인 출력
			} 

			try {
				//memberService = new MemberService(in, out);
				//lessonService = new LessonService(in, out);
				//boardService = new BoardService(in, out);
				boardService = new BoardService();
				boardService.loadData("board.bin");


			} catch (Exception e) {
				System.out.println("게시물 데이터 로딩 중 오류 발생!");
				//e.printStackTrace();//오류발생원인 출력
			} 

			while (true) {
				try (Socket socket = serverSocket.accept();
						ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
					
					boardService.init(in, out);
					memberService.init(in, out);
					lessonService.init(in, out);

					
					System.out.println("클라이언트와 연결되었음.");
					members.clear();
					ServerApp.in = in;
					ServerApp.out = out;

					//MemberService.in = in;
					//MemberService.out = out;
					//LessonService.in = in;
					//LessonService.out = out;
					//BoardService.in = in;
					//BoardService.out = out;

					// MemberService memberService = new MemberService(in, out);
					// LessonService lessonService = new LessonService(in, out);
					// BoardService boardService = new BoardService(in, out, "board.bin");



					loop: while (true) {
						String request = in.readUTF();
						System.out.println(request);

						if (request.startsWith("/member/")) {
							//MemberService.execute(request);
							memberService.execute(request);

						} else if (request.startsWith("/lesson/")) {
							//LessonService.execute(request);
							lessonService.execute(request);

						} else if (request.startsWith("/board/")) {
							//BoardService.execute(request);//이 서비스를 실행하라
							boardService.execute(request);//이 서비스를 실행하라

						} else if (request.equals("quit")) {
							quit();
							break loop;

						} else {
							out.writeUTF("FAIL");
						}
						out.flush();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트와의 연결을 끊었음.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void quit() throws Exception {
		try {boardService.saveData();//try블록에 같이 묶어놓으면 하나 저장하다가 에러가 뜨면 즉시 캐치 문으로 넘어가게된다.
		//그러면 member 와 lesson을 저장하지 못하게 된다.
		//그래서 따로 딸로 try -catch를 만드는 것이다.
	//	memberService.saveData();
	//	lessonService.saveData();
		} catch(Exception e) {//클라인엍트가 종료할때마다 사용해야 한다.
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		try {//boardService.saveData();
		memberService.saveData();
		//lessonService.saveData();
		} catch(Exception e) {//클라인엍트가 종료할때마다 사용해야 한다.
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		try {//boardService.saveData();
		//memberService.saveData();
		lessonService.saveData();
		} catch(Exception e) {//클라인엍트가 종료할때마다 사용해야 한다.
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		out.writeUTF("종료함!");
		out.flush();
	}
}

