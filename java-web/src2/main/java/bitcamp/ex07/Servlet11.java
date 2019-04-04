// 인클루딩(including)- 다른 서블릿의 작업을 포함시키기
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
@WebServlet("/ex07/s11")
public class Servlet11 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    //클라이언트가 서블릿의 실행을 요청할 때 서블릿 객체가 없으면 생성된다.
    //서블릿 객체가 생성될 때 이 메서드가 호출된다.
    //
    System.out.println("/ex06/s1=>init()");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
    //테스트 방법:
    //=>http://localhost:8080/java-web/ex07/s1?a=100&b=200&op=%2b
    //http://localhost:8080/java-web/ex07/s1?a=100&b=200&op=-
    //http://localhost:8080/java-web/ex07/s1?a=100&b=200&op=*
    //
    //주의
    //+연산을 수행하지 못한다. 왜? 서버에 전송될 때 '+'문자가 아닌 공백('')문자가 전달되기 때무닝다.
    //=>+연산자를 파라미터 값으로 보내고 싶다면 url 인코딩 해야 한다.
    //왜? + 문자는 url에서 한 개의 
    //+ 문자의 url 인코딩 값은?
    //  %2b
    //=>따라서 + 연산을 파라미터 값으로 보내려면
    //
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("계산 결과");
    
    String op = request.getParameter("op");
    
    RequestDispatcher 요청배달자 = request.getRequestDispatcher("/ex07/s11_error");
    if (!op.equals("+")) {
      //자신의 일이 아니라면 다른 서블릿으로 위임할수 있따.
      //=>요청을 다른 서블릿으로 전달할 수 있다.
      //요청배달자 = request.getRequestDispatcher(다른 서블릿 url);
      요청배달자 =request.getRequestDispatcher("/ex07/s11_plus");
      
      //이 서블릿이 지금까지 출력한 것은 모두 취소된다.
      //=>엥?
      //출력된 것이 취소 될수 이나요?
      //print writer 객체를 통해 
      //
      //=>
      //
      //
     
    } else if (op.equals("-")) {
      요청배달자 =request.getRequestDispatcher("/ex07/s11_minus");
    } else {
      요청배달자 =request.getRequestDispatcher("/ex07/s11_error");
    }
    
    //다른 서블릿을 실행시킨다. 실행이 완료되면 되돌아 온다.
    //forward()는 다른 서블릿으로 실행을 위임한 후 되돌아 오지 않지만,
    //incluse()는 다른 서블릿으로 실행을 위임한 후 되돌아 온다.
    요청배달자.include(request, response);
    
   out.println("--------------------------------------------");
    
  }
}

