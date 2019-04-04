//HTTP servlet 
package bitcamp.ex05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s4")
public class Servlet04 extends MyHttpServlet2 {
private static final long serialVersionUID = 1L;


//HTTP GET 요청에 응답하고 싶다면
//상속 받은 메서드 중에서 doGet()을 오버라이딩 한다.
@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  
    
  }




}
