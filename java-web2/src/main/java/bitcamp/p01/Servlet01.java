package bitcamp.p01;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet01 implements Servlet {
  
  ServletConfig config;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    // 서블릿 객체를 생성한 후 생성자 다음에 init 메서드가 호춣된다.
    this.config = config;
    System.out.println("Servlet01.init(ServletConfig)");
  }
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    // 클라이언트가 요청한 작업을 수행한다.
    System.out.println("Servlet01.service(ServletRequest req, ServletResponse re)");
  }
  
  @Override
  public void destroy() {
    // init()에서 준비한 자원을 destroy() 메서드에서 해제한다.
    System.out.println("Servlet01.destroy()");
  }
  
  @Override
  public ServletConfig getServletConfig() {
    // 서블릿에서 작업을 수해앟는 중에 서블릿 관련 설정 정보를 꺼낼때  이 메서드를 호출한다.,
    //init()의 파라미터 값을 리턴한다.
    System.out.println("Servlet01.getServletInfo()");
    return this.config;
  }
  
  @Override
  public String getServletInfo() {
    // 서블릿 컨테이너가 관리자 화면을 출ㄹ겨할 때 이 메서드를 호출한다.
    return "Servlet01";
  }

}
