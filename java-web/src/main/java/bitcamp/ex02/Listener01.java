//크랄이언트로 출력하기
package bitcamp.ex02;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//
public class Listener01 implements ServletContextListener {
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 웹 애플리케이션이 시작될 때 호출된다.
   System.out.println("Listener01.contextInitialized()");
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // 웹 애플리케이션이 종료될 때 호출된다.
    System.out.println("Listener01.contextInitialized()");
  }
}
