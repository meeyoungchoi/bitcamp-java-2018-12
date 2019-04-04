// 보관소에 값 넣기
package bitcamp.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex09/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
      // 테스트 방법:
    // => http://localhost:8080/java-web/ex09/s1
    //
    
    // 1) ServletContext 보관소에 값 넣기
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "aaa");
    
    // 2) HttpSession 보관소에 값 넣기
    // => 이 요청을 한 클라이언트의 HttpSession 객체가 없다면 만들어준다.
    // => 이미 이 클라이언트를 위해 만든 객체가 있다면 그 객체를 리턴한다.
    HttpSession session = request.getSession();
    session.setAttribute("v2","bbbb");
    
    // 3) ServletRequest 보관소에 값 넣기
    request.setAttribute("v3", "ccc");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("보관소에 값을 넣어씃브니다. -/ex09/s1");
    
    //응답 헤더에 Refresh 정보를 추가한다.
    //위에서 벌써 클라이언트에게 응답을 했는데 어떻게 응답 헤더를 출력할 수 있나요?
    //=>잊지 말자! out.println()이 출력한 것은 출력스트림 버퍼에 보관되어 있다.
    //따라서 아직 클라이언트에게 응답한 상태가 아니다.
    //그래서 다음과 같이 출력을 한 후에 응답 헤더 값을 추가하거나 변경할 수 있는 것이다.
    //메서드 호출이 완료될 때 비로소 클라이언트로 응답헤더와 message-body가 출력된다.
    //
    //
    //만약 out.println()/out.printf()/out.print() 등에서 출력한 내용이
    //버퍼를 꽉 채웠다면 어떻게 하나요?
    //=>그러면 자동으로 클라이언트에게 응답한다.
    //따라서 일단 클라이언트에게 응답을 하면 다음의 코드는 적용되지 않는다.
    //즉 응답을 완료한 후에 헤더 값을 변경하거나 바꿀 수 없다.
    //소용이 없다.
    //
  
  }
}

