// 10단계; 멀티 스레드 상황에서 DB커넥션을 공유할 떄의 문제점과 해결책
//
//9단계 멀티스레드에서 db커넥션 공유할 때의 문제점 확인하기
//1. 클라이언트1
//-photoboard/add를 실행한다.
//-사진 제목은 "aaa", 수업은 101로 입력한다.
//-사진 파일은 a.gif, b.gif를 입력한다.
//-mysql 클라이언트 프로그램을 이용하여 commit이 수행되기 전 상태를 확인한다.
//그리고 파일 입력을 잠시 멈춘다.
//2. 클라이언트2
//-/board/add를 실행한다.
//-mysql 클라이언트 프로그램을 이용하여 lms_board에 입력된 것을 확인한다.
//-또한 lms_photo와 lms_photo_file 테이블도 확인한다.
//-클라이언트1이 insert한 데이터도 들어가 있다.
//-왜?  클라이언트1과 클라이언트2의 요청을 처리할때 사용하는 db커넥션이 같기 때문이다.
//3. 클라이언트1
//-파일명을 255자가 넘어가게 입력한다. 
//-예외가 발생하면 rollback() 할 것이다.
//-그러나 이미 이전에 insert한 작업들은 클라이언트2가 commit 하면서 테이블에 저장되었기 때문에
//-rollback할수 없다.
//-이것이 멀티스레드에서 db커넥션을 공유할 때의 문제점이다.

//[해결책 1]
//dao가 작업할 때 매번 새 커넥션을 사용한다.
//Connection 팩토리를 사용하여 커넥션 객체를 준비한다.
//그래서 db커넥션풀을 사용한다.
//
//작업
//1.db커넥션 팩토리 객체를 생성한다.
//그래서 ConnectionFactory 클래스를 정의한다.
//com.eomcs.util.ConnectionFactory
//2. dao 구현체 변경
//메서드가 작업을 수행할 때 마다 ConnectionFactory에서 새 Connection을 얻은 다음에 작업을 수행한다.
//BoardDao, MemberDao, LessonDao, PhotoBoardDao, ~~~
//3. ApplicationInitializer 변경
//=>db커넥션은 dao에서 ConnectionFactory를 통해 얻기 떄문에
//이 클래스에서는 더이상 db커넥션 객체를 관리하지 않는다.
//또한 
//4) Abstractcommand변경
//execute() 호출이 완료되었을 때 commit() 또는 rollback()을 호출하지 않는다.
//dao가 사요하는 커넥션 객체를 모르기 때문에 사실상 commit() rollback()을 호출할 수 없다.

//dao에서 메서드가 호출될 때 새 커넥션을 사용하게 되면
//트랜잭션 관리가 불가능하다.
//다음철차에 따라 확인해보라
//실습:
//1./board/add
//2./board/list
//3./photoboard/add
//4./photoboard/list
//5./photoboard/add
//이때 첨부파일 두 개를 입력한 후, 세 번쨰 입력할 때 예외가 발생하도록
//긴 이름의 파일명을 입력한다.
//예외가 발생핬다는 메시지를 받을 것이다.
//6./photoboard.list
//예외가 발생하기 전까지 입력했던 데이터가 그대로 db에 보관된 것을 확인할 수 있다.
//즉 트랜잭션을 다룰수 없게 된다.
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









