//  인클루딩 - 다른 서블릿의 실행을 포함시키기
package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//클라이언트가 실행을 요청하지 않아도 서블릿을 미리 생성하고 싶다면,
//loadOnStartup 프로퍼티 값을 지정하라.
//  loadOnStartup=실행순서
//미리 생성할 서블릿이 여러 개 있다면, loadOnStartup에 지정한 순서대로 생성한다.
//언제 서블릿을 미리 생성하는가?
//=>서블릿이 작업할 떄 사용할 자원을 준비하는데 시간이 오래 걸리는 경우
//ㅇ웹 애플리케이션을 시작시킬 떄 미리 서블릿 객체를 준비한다.
//예) db 연결, 소켓 연결, 필요한 환경변수 로딩, 스프링 IoC 컨테이너 준비 등
//
@WebServlet("/ex07/s11_error")
public class Servlet11_error extends HttpServlet {





  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
    response.setContentType("text/plain;charset=UTF-8");
    
    //이미 이전 서블릿에서 setContentType()을 호출했기 때문에
    //이 서블릿에서는 할 필요가 없다.
    PrintWriter out = response.getWriter();
    out.println("해당 연산자를 지원하지 않습니다.");

    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    
    out.printf("%d - %d = %d\n", a,b,(a-b));
    
  }
}

