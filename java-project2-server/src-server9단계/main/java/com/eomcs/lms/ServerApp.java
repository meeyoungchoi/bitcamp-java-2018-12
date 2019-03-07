// 9단계; 서버에서 클라이언트 요청을 순차적으로 처리할 때 문제점과 해결책
//서버에서 클라이언트 요청을 처리하는 방법
//1. Stateful 방식
//서버와 연결한 후 연결을 끊을 때까지 계속 통신하는 방식이다.
//클라이언트가 연결을 끊지 않으면 서버쪽에 계속 소켓이 유지되기 때문에 메모리를 일정 점유한다.
//그래서 많은 클라이언트의 요청을 처리하지 못한다다.
//2.Stateless 방식
//서버와 연결한 후 요청 응답을 한번만 수행한다.
//그리고 연결을 끊는다.
//서버에서 응답을 완료하면 자동으로 연결을 끊기 때문에 서버 쪽에 소켓을 계속 유지하지 않는다.
//그래서 stateful방식에 비해 메모리 낭비가 덜하다.
//단 요청할때마다 서버와 연결해야 하기 때문에 연결하는데 일정시간이 소요된다.
//그러나 보다 많은 클라이언트 요청을 처리할 수 있어 대부분의 서비스에서 이 방식을 많이 사용한다.
//특히 stateless + 멀티스레드를 적용하면 동시에 많은 클라이언트 요청을 처리할 수 있다.
//대부분의 서비스 들이 이 조합을 사용한다.
//9단계의 목표가 스테이트레스 + 싱글스레드 방식을 stateless +멀티 스레드로 바꾸는 것이다.
//3.Stateless + multithread
//싱글스레드 방식을 스테이스레스 + 멀티스레드로 바꾸겠다.
//싱글스레드의 문제점 확인
//작업
//1.클라이언트 요청 처리를 전담할 스레드 클래스를 정의한다.
//requestHandlerThread
//2.싱글스레드에서 멀티스레드로 바꿨다.
//ServerApp의 service()가 수행하던 클라이언트 요청 처리를 RequestHandlerThread로 옮긴다.
//멀티스레드를 만들었을때 문제점=>싱글 커넥션을 사용할 때의 문제점
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









