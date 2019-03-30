package bitcamp.p02;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/p02/s1")
public class Servlet01 extends GenericServlet {

 private static final long seralVersionId = 1L;
 
 @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("/p02/s1 서블릿 실행");
    
  }
  
}
