// 16단계: 
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberService;
import com.eomcs.lms.service.Service;

//풀링기범
//자주 사용하는 인스턴스는 미리 생성하여 목록으로 보관하고 있다가
//필요할 때 빌려 쓰고 사용 후 반납하는 방식으로 인스턴스를 관리
//기존에 생성된 인스턴스를 재사용하기 때문에 
//기존의 객체를 재사용하기 때문에 인스턴스 생성에 시간이 많이 소요되는 경우에
//실행 시간을 줄일 수 있다.
//flyweight 디자인 패턴의 응용이다.
//스레드 풀
// 한번 생성한 스레드는 실행 후 버리지 않고 재사용한다.
//스레드 목록 관리에 풀링기법 적용

public class ServerApp {

	static BoardDaoImpl boardDao; 
	static MemberDaoImpl memberDao;
	static LessonDaoImpl lessonDao;

	static HashMap<String,Service> serviceMap;
	static Set<String> ServicekeySet;
	
	//스레드 풀
	//스레드 풀은 현재 놀고 있는 스레드를 꺼내서
	//파라미터로 넘겨 받은 RequestHandler의 run()을 호출하게 만든다.
	static ExecutorService executeService = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {

		try {
			boardDao = new BoardDaoImpl("board.bin");
			boardDao.loadData();
		} catch (Exception e) {
			System.out.println("게시물 데이터 로딩 중 오류 발생!");
		}

		try {
			memberDao = new MemberDaoImpl("member.bin");
			memberDao.loadData();
		} catch (Exception e) {
			System.out.println("회원 데이터 로딩 중 오류 발생!");
		}

		try {
			lessonDao = new LessonDaoImpl("lesson.bin");
			lessonDao.loadData();
		} catch (Exception e) {
			System.out.println("수업 데이터 로딩 중 오류 발생!");
		}

		serviceMap = new HashMap<>();
		serviceMap.put("/board/", new BoardDaoSkel(boardDao));
		serviceMap.put("/member/", new MemberService(memberDao));
		serviceMap.put("/lesson/", new LessonDaoSkel(lessonDao));

		 ServicekeySet = serviceMap.keySet();

		try (ServerSocket serverSocket = new ServerSocket(8888)) {
			System.out.println("서버 시작!");

			while (true) {
				//독립적으로 해야할 일을 스레드 풀에 맡긴다.
				executeService.submit(new RequestHandler (serverSocket.accept()));
				//클라이언트 요청을 받아서 응답하는 일을 스레드 풀에 맡긴다.
				//new RequestHandler (serverSocket.accept()).start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	static class RequestHandler implements Runnable {
		static int count = 0;
		
		Socket socket;
		String name;//핸들러의 고유 이름을 부여한다.

		public RequestHandler(Socket socket) {//메인스레드에서 호출한다.
			//super();
			this.name = "핸들러-" +count++;
			this.socket = socket;
			//스레드 이름 : 핸들러 이름
			System.out.printf("[%s:%s] 핸들러가 생성됨\n", 
					Thread.currentThread().getName(),//현재 이코드를 실행하는 스레드의 이름을 출력하고 핸들러 이름을 출력
					this.getName());//핸들러 이름
		}
		
		public String getName() {
			return this.name;
		}

		//독립적으로 수행할 코드를 run()메서드에 작성한다.
		public void run() {//스레드풀에서 놀고있는 스레드가 호출한다.
		try (Socket socket = this.socket;//close를 자동호출해달라
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

			System.out.printf("[%s:%s] 클라이언트와 연결되었음.\n", Thread.currentThread().getName(), this.getName());

			String request = in.readUTF();
			System.out.printf("[%s :%s] %s\n",
					Thread.currentThread().getName(),
					this.getName(),request);//request? 사용자가 입력한 내용

			Service service = getService(request);

			if (service == null) {
				out.writeUTF("FAIL");

			} else {
				service.execute(request, in, out);
			}
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}	try {Thread.currentThread().sleep(8000);;} catch(Exception e) {}
		
		System.out.printf("[%s : %s] 클라이언트와의 연결을 끊었음.\n", 
				Thread.currentThread().getName(),
				this.getName());//핸들러 이름
	}
	
	static Service getService(String request) {//사용자가 입력한 내용
		for (String key : ServicekeySet) {
			if (request.startsWith(key)) {
				return serviceMap.get(key);
			}
		}
		return null;
	}
}
}






