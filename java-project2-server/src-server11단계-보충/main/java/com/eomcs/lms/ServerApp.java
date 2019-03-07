// 11단계; 멀티 스레드 상황에서 DB커넥션을 공유할 떄의 문제점과 해결책 2
//같은 스레드를 통해 dao작업을 수행할 때 같은 커넥션 객체 사용하기
//어떻게?
//스레드 로컬(thread local) 변수 를 이요하여 커넥션 객체를 스레드에 보관한다.
//dao가 작업을 할 때 스레드에 보고나된 커넥션 객체를 이용한다. =>해결책
//
//작업:
//1. ConnectionFactory 변경
// =>create()를 호출할 때 먼저 스레드에 저장된 것이 있는지 검사한 후
//있으면 그 커넥션 객체를 리턴하고
//없으면 새 커넥션을 만들어 리턴한다.
//2. AbstractCommand 변경
//=>execute()에 commit()과 rollback()을 적용한다.
//3.Command 구현체 변경
//command에서 커넥션 객체를 사용한 후 닫지 않도록 한다.

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
		// TODO Auto-generated method stub
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
          return;//스레드 실행을 끝낸다.
        }
        
        commandHandler.execute(in, out);
        
        out.println("!end!");
        out.flush();

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        e.printStackTrace();
      } // try(Socket)
      
		
	}
  } 
}









