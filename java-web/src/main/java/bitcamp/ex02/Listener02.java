package bitcamp.ex02;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//ServletContainer가 관리하는 컴포넌트
//=>서블릿, 필터, 리스너
//
//리스너 만들기
//=>서블릿 컨테이너 또는 서블릿, 세션 등의 객체 상태가 변경되었을 때 보고 받는 옵저버
//=>"Observer" 디자인 패턴이 적용된 것이다.
//=>ServletContextListener
// -서블릿 컨테이너를 시작하거나 종료할 때 보고 받고 싶다면 이 컨테이너를 구현하라
//=>ServletRequest
// -
//=>HttpSessionListener
// -세션이 생성되거나 종료될 때 보고 받고 싶다면 이 인터페이스를 구현하라
//=>xxxListener
// -기타 
//
//리스너 배포하기
//=>dd 파일(web.xml)에 설정하거나 애노테이션으로 설정하면 도니다.
//
//리스너의 용도
//=>서블릿 컨테이너나 세션등이 특별한 상태일 때 필요한 작업을 수행한다.
//=>ServletContextListener
//-서블릿 컨테이너(웹 애프릴케이션)을 시작할 때 Spring IoC 컨테이너 준비하기
//-웹 애플리케이션을 시작할 때 db 커넥션 풀 준비하기
//-웹 애플리케이션을 시작할 때 db 커넥션 풀 준비하기
//-웹 애플리케이션을 종료할 때 db 커넥션 풀에 들어 있는 모든 연결을 해제하기
//=>servletRequestLIst
//
//
public class Listener02 implements ServletRequestListener {
  
  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    // 요청이 들어왔을 때 호출된다.
   System.out.println("Listener02.requestInitialized()");
  }
  
  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    // 웹 애플리케이션이 종료될 때 호출된다.
    System.out.println("Listener02.requestDestroyed()");
  }
}
