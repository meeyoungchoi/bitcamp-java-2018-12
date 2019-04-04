// 리다이렉트 - 응답할 때 콘텐트를 보내지 않는다.
//바로 다른 페이지를 요청하라고 명령하낟.
package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//웹 브라우저가 바라보는 루트는 웹 서버루트
//컨테이너가 바라보는 루트는 클라이언트 루트이다.

//컨텍스트 루트(웹 어플리케이션 루트)
@WebServlet("/ex08/s3")
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex08/s1
    //
    //리다이렉ㅇ트
    //=>클라이언트의 요청을 받은 후 콘텐트를 보내는 대신 
    //다른 페이지의 url을 알려줄 때 사용한다.
    //=>웹 브라우저는 응답받는 즉시 해당 페이지를 요청한다.
    //웹 서버로부터 콘텐트를 받지 않았기 때문에 어떤 것도 출력하지 않는다.
    //리프래시와 달리 서버는 콘텐트(message-body)를 보내지 않는다.
    //사용예) 
    //로그인 후  로그인 결과를 출력하지 않고 즉시 메인 화면으로 보내고 싶을 때
    //결제완료 후 결과를 춫
    //
    //라디이렉트 HTTP 응답 프로토콜
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    //HTML을 출력하는 경우
    //응답 헤더가 아니라 HTML 헤더에 리프래시 명령을 설저앟ㄹ 수 있다.
    
    out.println("<html><head>");
    out.println("<title>리다이렉트</title>");
    out.println("</head><body>");
    out.println("안녕하세요! -/ex08/s1");
    //버퍼가 꽉차서 클라잉언트로 자동으로 출력되어 리다이렉트가 안먹히는 상황을 보고싶다면 
    //다음 반복문 주석을 푸라!
   // for (int i = 0; i <3000; i++) {
   // out.println("</body></html>");

    //}
    //클라이언트에게 url을 알려줄 때 상대 결로를 지정할 수 있다.
    //forward/include와 달리 '/'컨텍스트 루트(웹 애플리케이션 루트)가 이니
    //8080/=>웹 서버
    //java-web/=>웹 애플리케이션 루트
    response.sendRedirect("s100");
    
    //리다이렉트를 하는 순간 이전까지 버퍼로 출력된 내용을 모두 버려진다.
    //왜? 리다이렉틀르 클라이언트로 콘텐트를 보내지 않는다.
    //
    //만약 출력한 내요잉 버퍼를 꽉 채워서 자동으로 응답을 했다면 어떻게 하나요?
    //=>이미 응답했기 때문에 리다이렉트는 동작되지 않는다.
    
  }
}

