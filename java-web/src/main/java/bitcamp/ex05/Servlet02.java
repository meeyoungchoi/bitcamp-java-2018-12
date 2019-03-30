//  http프로토콜 다루기 - HttpServlet 클래스를 활용하기
package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 애노테이션
//=>web.xml에 서블릿 정보를 설정하는 대신에
//이 애노테이션을 사용하여 서블릿을 설정할 수 있다.
//=>이 애노테이션을 활성화시키려명
//web.xml의 <web-app> 태그에 다음 속서을 추가해야 한다.
// metadata-complete="false"
//속성의 값은 false 여야 한다.
//하나의 이름에 서블릿이 두개 3개 있는건 안된다.
@WebServlet("/ex05/s2")
public class Servlet02 extends MyHttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //테스트
   //-http://localhost:8080/java-web/ex05/test01.html
    
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    //HttpServletRequest에는 http 프로토콜의 요청 방식을 리턴하는 메서드가 있다.
    if (request.getMethod().equals("GET")) {//클라이언트가 get 방식으로 요청했는지 post 방식으로 요청해줬는지를 리턴해준다.
      out.println("GET 요청입니다.");
    } else if (request.getMethod().equals("POST")) {
      out.println("POST 요청입니다.");
      
    } else {
      out.println("이 서블릿이 다루지 못하는 요청 방식이다,");
    }
      
    


  }

}




