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

//멀티 스레드 적용
//클라이언트 요청을 별도의 스레드에서 처리한다.
//작업
//1. 클라이언트의 요청작업을 처리하는 코드를 별도의 스레드 클래스로 분리한다.
//requestProcessorThread 클래스 정의
//2. 클라이언트가 연결되었을 때 스레드에게 실행을 위임한다.

public class ServerApp {

	static BoardDaoImpl boardDao; 
	static MemberDaoImpl memberDao;
	static LessonDaoImpl lessonDao;

	static HashMap<String,Service> serviceMap;
	static Set<String> ServicekeySet;
	
	//스레드 풀
	ExecutorService executeService = Executors.newCachedThreadPool();
	
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
			
				new RequestProcessorThread(serverSocket.accept()).start();//명령을 내린다음에
				//스레드를 시작시킨 후 즉시 리턴한다.
				//스레드가 작업을 종료할 떄까지 기다리지 않는다.
				//즉 비동기로 동작한다.
				//첫번쨰 연결된 클라이언트가 일이 끝나지 않았더라도 그다음 소켓을 꺼내서 일을 시작한다.
				//run()메서드를 비동기적으로 실행시켜라 하면서 즉시 리턴한다.
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class RequestProcessorThread extends Thread {
		Socket socket;

		public RequestProcessorThread(Socket socket) {
			super();
			this.socket = socket;
			System.out.printf("[%s] 스레드가 생성됨\n", this.getName());
		}

		//독립적으로 수행할 코드를 run()메서드에 작성한다.
		public void run() {
		try (Socket socket = this.socket;//close를 자동호출해달라
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

			System.out.printf("[%s] 클라이언트와 연결되었음.\n", this.getName());

			String request = in.readUTF();
			System.out.printf("[%s] %s\n",this.getName(),request);

			Service service = getService(request);

			if (service == null) {
				out.writeUTF("FAIL");

			} else {
				service.execute(request, in, out);
			}
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.printf("[%s] 클라이언트와의 연결을 끊었음.\n",this.getName());	  
		}
	}
	
	static Service getService(String request) {
		for (String key : ServicekeySet) {
			if (request.startsWith(key)) {
				return serviceMap.get(key);
			}
		}
		return null;
	}
}






