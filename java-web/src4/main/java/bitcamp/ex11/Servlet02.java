// 세션(session) - 세션에서 값 꺼내기
package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/s2")
@SuppressWarnings("serial")
public class Servlet02 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
      // 테스트 방법:
    // => http://localhost:8080/java-web/ex11/s2

    //세션 아이디 보내기
    //=>서버로부터 세션 아이디 쿠키를 받은 웹 브라우저는 해당 서버에 요청할 때마다 
    //세션 아이디 쿠키를 보낸다.
    //=>Http요청 프로토콜
    
    //세션
    //=>클라이언트를 식별하는 기술
    //=>HTTP 프로토콜은 Stateleess방식으로 통신을 한다.
    //즉 연결한 후 요청하고 응답을 받으면 연결을 끊는다.
    //그래서 서버는 클라이언트가 요청할 때 마다 누구인지 알 수 없다.
    //=>이를 해결하기 위해 클라이언트가 접속하면 웹 서버는 그 클라이언트를 위한
    //고유 번호를 발급(쿠키 이용)한다.
    // 이 고유 번호를 '세션아이디'라 부른다.
    //=>웹 브라우저는 세션 아이디를 보관해 두었다가 그 서버에 요청할 때 마다 
    // 세션 아이디를 보낸다/
    //왜? 세션 아이디는 쿠키이다.
    //세션 아이디 쿠키는 유효 기간을 설정하지 않았기 때문에
    //웹 브라우저를 종료하면 세션 아이디 쿠키는 삭제된다.
    //=>세션 아이디 쿠키의 사용 범위는 웹 애플리케이션이다.
    //예) /java-web
    //따라서 같은 웹 애플리케이션의 서블릿을 실행할 때는 무조건 세션 아이디를 보낸다.
    //
    //세션 아이디는 언제 발급하는가?
    //=>웹 브라우저가 세션 아이디를 보내지 않으면 발급해 준다.
    //=>세 세션을 생성할 때 세션 아이디를 발급한다.
    //
    //언제 새 세션을 생성하는가?
    //=>세션이 없는 상태에서 request.getSession()을 호출할 때 생성한다.
    //
    
    
/*
 * 
 * GET /java-web/ex11/s2 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*//*;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cookie: JSESSIONID=4BAD91FF027EFFAE9ED5DF287D292095 <---서버에 세션아이디를 보낸다.*/
    HttpSession session = request.getSession();
    
  
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
  //세션에서 값 꺼내기
    //=>웹 브라우저를 종료한 후 다시 실행하면 이전에 /ex11/s1을 실행했을 때
    //서버로부터 받은 세션 아이디 쿠키가 삭제된 상태다.
    //=>그런후에 웹 브라우저에서 이 서블릿을 요청하면
    //getSession()메서드를 새 세션 ㄱ개체를 생성한 후 리턴하낟.
    //따라서 새 세션에는 v1이라는 이름으로 설정된 
    out.printf("v1=%s\n", session.getAttribute("v1"));
  }
}

