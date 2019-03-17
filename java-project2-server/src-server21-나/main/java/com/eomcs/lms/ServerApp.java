// 21단계: 자바 설정 방식을 이용하여 IoC 컨테이너를 설정하기
//=>Ioc 컨테이너에게 필요한 것들을 자바 코드로 설정한다.
//
//작업1 - 팩토리 메서드를 통해 객체 생성하기
//1) AppConfig 정의
//  =>  IoC 컨테이너가 보관할 객체를 생성해주는 메서드 정의1.
//  =>  IoC 컨테이너가 자동으로 생성하지 않는 객체를 메서드에서 리턴하다.
//2) IoC 컨테이너가 빈을 생성하기 위해 호출해야 할 메서드를 표시하는 애노테이션 이다,2.
//=>IoC 컨테이너가 보관해야 하는 객체를 만들어주는 메서드를 표시할 떄 사용한다.
//=>IoC 컨테이너는 이 애노테이션이 붙은 메서드를 호출하여 그 리턴값을 보관할 것이다.
//3.APpCOnfig변경
//=>객체를
//왜? 애노테이션이 붙은 것만 호출하기 위해
//4). ApplicationContext변경
//=>생성자의 파리미터로 받은 클래스에 대해 설정작업 수행
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import com.eomcs.lms.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.Response;

public class ServerApp {

  // ApplicationContextListener(옵저버) 목록을 보관할 객체
  ArrayList<ApplicationContextListener> listeners = new ArrayList<>();

  // 공용 객체를 보관하는 저장소 
  HashMap<String,Object> context = new HashMap<>();
  
  //Command 객체와 그와 관련된 객체를 보관하고 있는 빈  컨테이너
  ApplicationContext beanContainer;
  
  //클라이언트 요청을 처리할 메서드 정보가 들어있는 객체
  RequestMappingHandlerMapping handlerMapping;

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888)) {
      

      // 애플리케이션을 시작할 때, 등록된 리스너에게 알려준다.
      for (ApplicationContextListener listener : listeners) {
        listener.contextInitialized(context);
      }
      
      //ApplicationInitializer가 준비한 ApplicationContext를 꺼낸다.
      beanContainer = (ApplicationContext) context.get("applicationContext");
      
      //빈 컨테이너에서 RequestMappingHandlerMapping객체를 꺼낸다.
      //이 객체에 클라이언트 요청을 
      handlerMapping =
    		  (RequestMappingHandlerMapping) beanContainer.getBean("handlerMapping");
      
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
        //=>클라이언트 요청을 처리할 객체는 빈 컨테이너에서 꺼낸다.(보드디에오임플을 빈컨테이너에서 꺼낸다.)
        //리케스트를 가져와서 
        RequestMappingHandler requestHandler = handlerMapping.get(request);
        
        if (requestHandler == null) {
          out.println("실행할 수 없는 명령입니다.");
          out.println("!end!");
          out.flush();
          return;
        }
        
        try {
        	//클라이언트 요청을 처리할 메서드를 찾았다면 호출한다.
        	requestHandler.method.invoke(
        			requestHandler.bean, //메서드를 호출할 때 사용할 인스턴스
        			new Response(in, out));//메서드 파라미터 값
        } catch (Exception e) {
          out.printf("실행 오류! : %s\n", e.getMessage());
          e.printStackTrace();
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









