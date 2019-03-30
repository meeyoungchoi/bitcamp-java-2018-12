//필터나 리스너를 테스트하기 위한 서블릿
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
@WebServlet("/ex03/s1")
public class Servlet01 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    //출력 스트림을 꺼내기 전에 출력할 때 사용할 문자표(charset)를 지정하지 않으면
    //기본이 영어 문자로 간주하여 (Ascii)로 변환하여 출력한다.
    //자바(unicode2;UTF-16) ==> 출력문자(ASCII)
  PrintWriter out = res.getWriter();
  out.println("Hello");
  out.println("안녕하세요!");
  out.println("こんばんは");
  out.println("sécurité");
  out.println(" مع السلامة؛ إلى اللقاء!");
    
  }
  
}
