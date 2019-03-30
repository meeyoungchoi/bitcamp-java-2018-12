//  클라이언트로 출ㄹ겨하기 - 한글 깨짐 현상 처리
package bitcamp.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// @WebServlet 애노테이션
//=>web.xml에 서블릿 정보를 설정하는 대신에
//이 애노테이션을 사용하여 서블릿을 설정할 수 있다.
//=>이 애노테이션을 활성화시키려명
//web.xml의 <web-app> 태그에 다음 속서을 추가해야 한다.
// metadata-complete="false"
//속성의 값은 false 여야 한다.
//하나의 이름에 서블릿이 두개 3개 있는건 안된다.
@WebServlet("/ex03/s3")
public class Servlet03 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

 
    //html을 출ㄹ겨할 때 mine 타입에 html을 지정하지 않으면
    //읿반 텍스트 그대로 출력한다.
    res.setContentType("text/html;charset=UTF-8"); //utf-16 ==> utf-8
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>servlet03</title></head>");
    out.println("</body><h1>안녕하세요</h1></body");
    out.println("</html>");
    


  }

}
