// 4단계: command를 다루는 클래스에 대해 리펙토링 수행
//command를 미리 구현한 AbstractCommand 클래스 생성
//클라이언트의 데이터를 읽고 출력하는 것을 담당할
//request와 response 클래스 생성
//기존 command 구현체는 직접 command 인터페이스를 구현하는 대신에
//abstractcommand를 상속 받도록 변경
//또한 execute(BufferedReader, PrintWriter)대신에
//
//
// 클라이언트와 서버 사이의 통신 규칙

package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class ServerApp {

	// ApplicationContextListener(옵저버) 목록을 보관할 객체
	ArrayList<ApplicationContextListener> listeners = new ArrayList<>();


	public void addApplicationContextListener(ApplicationContextListener listener) {
		listeners.add(listener);
	}

	public void service() throws Exception {

		try (ServerSocket ss = new ServerSocket(8888)) {

			// App에서 사용할 객체를 보관하는 저장소
			HashMap<String,Object> context = new HashMap<>();


			// 애플리케이션을 시작할 때, 등록된 리스너에게 알려준다.
			for (ApplicationContextListener listener : listeners) {
				listener.contextInitialized(context);
			}

			System.out.println("서버 실행 중...");

			while (true) {

				try (Socket socket = ss.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintWriter out = new PrintWriter(socket.getOutputStream())) {

					String request = in.readLine();
					if (request.equalsIgnoreCase("stop")) {
						System.out.println("서버를 종료합니다.");
						break;
					}

					//클라이언트에게 응답하기
					Command commandHandler = (Command) context.get(request);

					if (commandHandler == null) {
						out.println("실행할 수 없는 명령입니다.");
						out.println("!end!");
						out.flush();
						continue;
					}


					try {
						commandHandler.execute(in, out);

						out.println("!end!"); 
						out.flush();

					}	catch (Exception e) {
						System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
						e.printStackTrace();
					}
				}//try(Socket)
			}//while



			// 애플리케이션을 종료할 때, 등록된 리스너에게 알려준다.
			for (ApplicationContextListener listener : listeners) {
				listener.contextDestroyed(context);
			}


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
	}









