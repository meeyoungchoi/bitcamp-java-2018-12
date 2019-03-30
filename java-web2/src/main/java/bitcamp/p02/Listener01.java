package bitcamp.p02;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener01 implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
   
    System.out.println("Listener.contextInitializer()");
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("Listener.contextDestroyed()");
    
  }
}
