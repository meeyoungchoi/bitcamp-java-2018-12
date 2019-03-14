// 13단계: MyBatis 퍼시스턴스 프레임워크 적용하기
//자바 소스 코드에서 sql을 분리하여 별도의 파일에서 관리한다.
//jdbc 코드를 캡슐화 하여 db프로그래밍을 간결하게 한다.
//
//작업
//1.Mybatis 설정 파일 준비
//src/main/resources/com/eomcs/lms/conf/mybatis-config.xml생성
//src/main/resources/com/eomcs.
//2.LessonDao에 mybatis 적용
//src/main/resources/com/eomcs/lms/mapper/lesson.mapper.xml 생성
//lessonDaoImpl생성
//

package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;
import com.eomcs.util.DataSource;

public class ServerApp {

	// ApplicationContextListener(옵저버) 목록을 보관할 객체
	ArrayList<ApplicationContextListener> listeners = new ArrayList<>();

	//서비스메서드안의 로컬변수
	// App에서 사용할 객체를 보관하는 저장소
	//인스턴스 변수로 만들어줬다. => 공용 객체를 보관하는 저장소
	HashMap<String,Object> context = new HashMap<>();

	public void addApplicationContextListener(ApplicationContextListener listener) {
		listeners.add(listener);
	}

	public void service() throws Exception {

		try (ServerSocket ss = new ServerSocket(8888)) {
			

			// 애플리케이션을 시작할 때, 등록된 리스너에게 알려준다.
			for (ApplicationContextListener listener : listeners) {
				listener.contextInitialized(context);
			}

			System.out.println("서버 실행 중...");

			while (true) {
				//리케스트 핸들러 스래드 생성
				new RequestHandlerThread(ss.accept()).start();  //이제 클라이언트와 대화를 시작해
				//즉시 다음 스레드도 부른다.
				//대기열에 새 클라이언트가 들어올 때 까지 기다렸다가 그 일을 스레드에게 맞긴다.
			} // while

			// 애플리케이션을 종료할 때, 등록된 리스너에게 알려준다.
			//Unreachable code=>현재 while문은 종료 조건이 없기 때문에 다음 묹장을 실행할 수 없다.
			// 주석으로 처리
			/*
			 * for (ApplicationContextListener listener : listeners) {
        listener.contextDestroyed(context);
      }*/

		} catch (Exception e) {
			e.printStackTrace();
		} // try(ServerSocket)

	}

	public static void main(String[] args) throws Exception {
		ServerApp app = new ServerApp();

		// App이 실행되거나 종료될 때 보고를 받을 옵저버를 등록한다.
		app.addApplicationContextListener(new ApplicationInitializer());

		// App 을 실행한다.
		app.service();
	}

	//바깥 클래스의 인스턴스 필드를 사용한다면 inner 클래스로 정의하라
	//instance nested 클래스로 만들어야 한다.
	class RequestHandlerThread extends Thread {//static nested class => 일반 메서드로 생각하라
		//바깥 클래스의 인스턴스필드를 사용해야 한다면 inner클래스로 정의하라(none static nested class)로 정의하라

		Socket socket;

		public RequestHandlerThread(Socket socket) {
			this.socket = socket;//인스턴스를 가리킬때는 this를 붙인다.
		}

		@Override
		public void run() {

			//DB커넥션을 빌려줄 커넥션풀을 꺼낸다.
			DataSource dataSource = (DataSource) context.get("dataSource");

			//커넥션풀에서 현재 스레드가 사용할 커넥션 객체를 빌린다.
			Connection con = dataSource.getConnection();//새로 db 커넥션 생성함!

			try (Socket socket = this.socket;
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream())) {

				// 클라이언트의 요청 읽기
				String request = in.readLine();

				// 클라이언트에게 응답하기
				Command commandHandler = (Command) context.get(request);

				if (commandHandler == null) {
					out.println("실행할 수 없는 명령입니다.");
					out.println("!end!");
					out.flush();
					return;
				}

				
				try {
			          commandHandler.execute(in, out);
			          // 클라이언트 요청을 처리한 후 커넥션을 통해 작업한 것을 최종 완료한다.
			          con.commit();
			          System.out.println("DB 커넥션에 대해 commit 수행");
			        } catch (Exception e) {
			          // 만약 클라이언트 요청을 처리하는 동안에 예외가 발생했다면 
			          // 커넥션을 통해 수행했던 모든 데이터 변경 작업을 취소한다.
			          try {
			            con.rollback();
			            System.out.println("DB 커넥션에 대해 rollback 수행");
			          } catch (SQLException e1) {
			            // rollback() 하다가 발생된 예외는 무시한다. 왜? 따로 처리할 방법이 없다.
			          }
			          out.printf("실행 오류! : %s\n", e.getMessage());
			        }
			        
			        out.println("!end!");
			        out.flush();

			} catch (Exception e) {
				//만약 클라이언트 요청을 처리하는 동안에 예외가 발생했다면 
				//커넥션을 통해 수행했던 모든 데이터 변경 작업을 취소한다.
				System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
				e.printStackTrace();
			} // try(Socket)
			finally {
				//
				//커넥션 객체를 close() 해서는 안된다.
				//왜?
				dataSource.returnConnection(con);//커넥션은 반납한다.
				System.out.println("DB커넥션을 커넥션풀에 반납");
			}

		} 

	}
} 










