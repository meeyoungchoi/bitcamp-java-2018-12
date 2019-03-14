// 14단계: Mybatis 퍼시스턴스 프레임워크에 트랜잭션 관리자 도입하기
// 트랜잭션 관리자를 도입하여 여러 개의 데이터 변경 작업을 한 단위의 작업으로 묶어 다룬다.
//
//작업
//1. SqlSessionFactoryProxy 생성
//mybaris가 제공하는 sqlsessionfactory를 대행한다.
//트랜잭션을 위한 sqlSession객체를 준비하고 해제하는 일을 한다.
//트랜잭션을 시작하면 스레드 보관소에 sqlSession객체를 보관한다.
//그래서 스레드가 수행하는 모든 데이터 변경 작업을 한 sqlSession 객체가 다루게 한다.
//2.sqlSessionProxy 생성
//mybatis가 제공하는 sqlSession객체를 대행한다.
//트랜잭션 중에는 close()를 하지 않는다.
//3. transactionManager 생성
//트랜잭션을 시작시키고 완료시키는 일을 한다.
//sqlSession 객체를 통해 데이터 변경 작업들을 commit()하고 rollback()하는 일을 한다.
//4.dao변경
//dao에서 데이터 변경(crud) 후에 commit()하지 마라
//트랜잭션을 사용할 때는 dao에서 커밋 하는것이 아니다.
//왜? 여러 dao의 작업을 한 단위로 묶어서 commit() 해야 하기 때문이다.
//실무에서도 커밋하면 안된다.
//그러면 트랜잭션을 사용하지 않을 때는 auto commit이 true인 sqlSession을 사용하기 때문에
//아무런 문제가 없다.
//오토커밋이 펄스인 경우마 커밋을 호출하면된다.
//5. command변경
//트랜잭션을 사용해야 하는 command에 대해서는 transactionManager를 주입하라
//photoboardaddcommand, phofoboarddeletecommand photoboardupdatecommand lessondeletecommand
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

  // 공용 객체를 보관하는 저장소
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
        new RequestHandlerThread(ss.accept()).start();
      } // while

      // 애플리케이션을 종료할 때, 등록된 리스너에게 알려준다.
      // => 현재 while 문은 종료 조건이 없기 때문에 다음 문장을 실행할 수 없다.
      //    따라서 주석으로 처리한다.
      /*
      for (ApplicationContextListener listener : listeners) {
        listener.contextDestroyed(context);
      }
      */

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
  
  // 바깥 클래스(ServerApp)의 인스턴스 필드를 사용해야 한다면 
  // Inner 클래스(non-static nested class)로 정의하라!
  // 
  class RequestHandlerThread extends Thread {
    
    Socket socket;
    
    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      
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
        } catch (Exception e) {
          out.printf("실행 오류! : %s\n", e.getMessage());
        }
        
        out.println("!end!");
        out.flush();
        
      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        e.printStackTrace();
        
      }
    }
  }
  
  
  
}









