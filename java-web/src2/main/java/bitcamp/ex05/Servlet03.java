package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet03 extends MyHttpServlet2 {
private static final long serialVersionUID = 1L;



/*@Override
public void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException {

 
  HttpServletRequest httpReq = (HttpServletRequest) req;
  HttpServletResponse httpRes = (HttpServletResponse) res;
  
  res.setContentType("text/plain;charset=UTF-8");
  PrintWriter out = res.getWriter();
  
  //HttpServletRequest에는 http 프로토콜의 요청 방식을 리턴하는 메서드가 있다.
  if (httpReq.getMethod().equals("GET")) {//클라이언트가 get 방식으로 요청했는지 post 방식으로 요청해줬는지를 리턴해준다.
    out.println("GET 요청입니다.");
  } else if (httpReq.getMethod().equals("POST")) {
    out.println("POST 요청입니다.");
    
  } else {
    out.println("이 서블릿이 다루지 못하는 요청 방식이다,");
  }
    
  


}
*/

@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    
  }




}
