// 보관소에 값 넣기
package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
      // 테스트 방법:
    // => http://localhost:8080/java-web/ex10/s1

    //쿠키
    //=>웹서버가 웹 브라우저에게 맡기는 데이터이다.
    //=>응답할 때 응답 헤더에 포함시켜 보낸다.
    //=>웹 브라우저는 응답헤더로 받은 쿠키 데이터를 보관하고 있다가
    //지정된 url을 요청헤더에 포함시켜 웹 서버에게 쿠키를 보낸다.
    //
    
    //HTTP/1.1 200
    //Set-Cookie: name=hong   <-----Set-Cookie 
    //Set-Cookie: age=20
    //Set-Cookie: working=true
    //Set-Cookie: name2=홍길동
    //Content-Type: text/plain;charset=UTF-8
    //Content-Length: 34
   // Date: Wed, 03 Apr 2019 00:59:21 GMT
    
    /**
     * HTTP/1.1 200
Set-Cookie: name=hong <---set cookie
Set-Cookie: age=20
Set-Cookie: working=true
Set-Cookie: name2=홍길동 <--url 인코딩 하지 않은 상태
Set-Cookie: name3=%ED%99%8D%EA%B8%B8%EB%8F%99  <----url 인코딩한 예
Content-Type: text/plain;charset=UTF-8
Content-Length: 34
Date: Wed, 03 Apr 2019 01:03:41 GMT
     * 
     * 
     * */
    
    //쿠키 생성
    //=>이름과 값으로 생성한다.
    //=>쿠키의 유효기간을 설정하지 않으면 웹 브라우저가 종료될 때 까지 유지된다.
    //웹 브라우저를 종료하면 웹 서버로 부터 벋은 유효기간이 지정되지 않은 쿠키를 모두 삭제된다.
    //=>쿠키의 사용범위를 짖어하지 ㅇ낳으면 현재 경ㅇ로에 한정한다.
    //쿠키를 보낼때의 url이 /ex10/s1이라면,
    //웹브라우저는 /ex10/*결로를 요청할 때만 웹서버에게 쿠키를 보낸다.
    Cookie c1 = new Cookie("name", "hong");
    //값은 반드시 문자열이어야 한다.
    //만약 문자열이 아닌 값을 보내려면 Base64와 같은 인코딩 기법을 이용하여
    //바이너리 데이터를 문자화시켜서 보내야 한다.
    Cookie c2 = new Cookie("age","20");
    Cookie c3 = new Cookie("working","true");
    
    //=>또한 값은 반드시 IS0-8859-1이어야 한다.
    //만약 utf-8을 보내고 싶다면 url 인코딩 같은 기법을 사용하여 
    // ASCII코드화 시켜 보내야 한다.
    Cookie c4 = new Cookie("name2", "홍길동");
    Cookie c5 = new Cookie("name3", URLEncoder.encode("홍길동","UTF-8"));
    
    //쿠키를 응답헤더에 포함시키기
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
    response.addCookie(c4);
    response.addCookie(c5);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("쿠키 보냈습니다. -/ex10/s1");  
  }
}

