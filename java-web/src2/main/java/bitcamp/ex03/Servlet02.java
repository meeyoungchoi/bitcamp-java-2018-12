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
@WebServlet("/ex03/s2")
public class Servlet02 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    //한글 깨짐 처리하기
    //=>출력 스트림을 꺼내기 전에 출력할 때 사용할 문자표(charset)를 지정하라
    //=>반드시 철겨 스트림을 얻기 전에 설정해야 한다.
    //res.setContentType("mime Type;charset=문자표이름"));
    res.setContentType("text/plain;charset=UTF-8"); //utf-16 ==> utf-8
    PrintWriter out = res.getWriter();
    out.println("Hello");
    out.println("안녕하세요!");
    out.println("こんばんは");
    out.println("sécurité");
    out.println(" مع السلامة؛ إلى اللقاء!");

  }

}
