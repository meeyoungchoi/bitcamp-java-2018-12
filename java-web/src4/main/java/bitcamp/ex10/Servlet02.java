// 쿠키 읽기
package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/s2")
@SuppressWarnings("serial")
public class Servlet02 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
      // 테스트 방법:
    // => http://localhost:8080/java-web/ex10/s2
    
    //클라이언트가 보낸 쿠키 읽기
    //=>요청 헤더에 포함된 쿠키를 읽는다.
    //=>http 요청 프로토콜 

    //쿠키
    //=>웹서버가 웹 브라우저에게 맡기는 데이터이다.
    //=>응답할 때 응답 헤더에 포함시켜 보낸다.
    //=>웹 브라우저는 응답헤더로 받은 쿠키 데이터를 보관하고 있다가
    //지정된 url을 요청헤더에 포함시켜 웹 서버에게 쿠키를 보낸다.
    //
    

    /*
     * GET /java-web/ex10/s2 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*//*;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7


Cookie: name=hong; age=20; working=true; name2=홍길동; name3=%ED%99%8D%EA%B8%B8%EB%8F%99ㄴ
     * 
     */
    
    //쿠키 꺼내기
    //=>쿠키를 이름으로 한 개씩 추출할 수 없다.
    //한번에 배열로 받아야 한다.
    //=>요청헤더에 쿠키가 단 한 개라도 없으면 리턴 되는 것은 null이다.
    Cookie[] cookies = request.getCookies();

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    if (cookies != null) {
   for  (Cookie c : cookies) {
     out.printf("%s=%s\n", c.getName(), c.getValue());
     if (c.getName().equals("name3")) {
       //쿠키 값이 url 인코딩한 값이라면 원래의 값으로 되돌리기 위해
       //url 디코딩 해준다.
       out.printf("  => %s\n", URLDecoder.decode(c.getValue(), "UTF-8"));
     }
   }
   }
   //url인코딩된 쿠키는 url 디코딩 시켜야 한다.
    
  }
}

