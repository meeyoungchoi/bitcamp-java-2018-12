// 쿠키 사용버위 지정하기
package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/s21") //서벌릿 컨테이너가 이 경로를 사용한다. 이때 이 루트는 웹 어플리케이션 루트 즉 컨텍스트 루트이다.
@SuppressWarnings("serial")
public class Servlet21 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
      // 테스트 방법:
    // => http://localhost:8080/java-web/ex10/s21

    //쿠키 사용범위
    //=>쿠키의 사용 범위를 지정하지 않으면 쿠키를 발행한 url 범위에 한정된다.
    //즉 같은 url로 요청할 때만 쿠키를 보내야 한다.
    //=>예)
    //쿠키를 발행한 url : /ex10/s21
    //쿠키를 보낼 수 있는 url:  /ex10/*
    //쿠키를 보낼 수 없는 url : /ex10이외의 모든 url
    
    //=>HTTP 응답 프로토콜 
    
    /*
     * HTTP/1.1 200
Set-Cookie: v1=aaa  <----사용 법위가 지정되지 않았다.
Set-Cookie: v2=bbb; Path=/java-web/ex10/a <---사용 범위가 /java-web/ex10/a
Set-Cookie: v3=cccc; Path=/java-web
Content-Type: text/plain;charset=UTF-8
Content-Length: 35
Date: Wed, 03 Apr 2019 02:05:50 GMT
     * 
     * 
     * */
    //웹브라우저는 /ex10/*결로를 요청할 때만 웹서버에게 쿠키를 보낸다.
    Cookie c1 = new Cookie("v1", "aaa");
    
    //경로를 지정하지 않으면 쿠키를 발생한 웹 서버와 같은 서버일때만 웹 서버가 쿠키를 보낸다.
    
  //사용 범위 지정
    Cookie c2 = new Cookie("v2","bbb");
    c2.setPath("/java-web/ex10/a");//웹 브라우저에게 던져주는 경로  
   //웹 브라우저는 루트를 서브르투로 바라본다
    //서브루트: 서버주소 다음에 오는 루트
    //생략하면 포트번호는 80이다.
    //그래서 쿠키의 경로를 적을때는 웹 어플리케이션 루트까지 적어줘야 한다.
    Cookie c3 = new Cookie("v3","cccc");
    c3.setPath("/java-web");//java-web으로 시작하면 다 보내야지
    
    //아~ 왜 쿠키의 경로를 적을 때 웹 애플리케이션 루트(컨텍스트 루트)까지 적나요?
    //=>쿠키 경로는 서블릿 컨테이너가 사용하는 경로가 아니다.
    //=>웹 브라우저가 사용하는 경로다/
    //=>웹 브라우저에서 '/'은 서버 루트를 의미한다.
    //=>따라서 웹 브라우저가 사용하는 경로를 지정할 때는 조심해야 한다.
    //'/'가 서버 루트를 의미하기 때문이다.
    //=>그래서 쿠키의 경로를 지정할 때는 웹 애플리케이션 루트(컨텍스트 루트)를 정확하게 지정해야 한다.
    
    //쿠키를 응답헤더에 포함시키기
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);

    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("쿠키 보냈습니다. -/ex10/s21");  
  }
}

