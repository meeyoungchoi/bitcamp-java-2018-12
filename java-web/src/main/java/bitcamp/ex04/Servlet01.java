//  클라이언트가 보낸 데이터 읽기 - get 요청 데이터 읽기
package bitcamp.ex04;

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
@WebServlet("/ex04/s1")
public class Servlet01 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    //Get요청
    //-웹 브라우저에 url을 입력한 후 엔터를 치면 get 요청을 보낸다.
    //-웹 페이지에서 링크를 클릭하면(자바스크립트 처리하지 않은 상태) get요청을 보낸다.
    //-웹 페이지의 폼(method='GET'일 때)에서 전송 버튼을 클릭하면
    //
    //테스트
    //-/ex04/test01.html 실행
    //
    
    //웹 브라우저가 보낸 데이터 읽기
    //ServletRequest.getParameter("파라미터이름");
    String name = req.getParameter("name");
    int age = Integer.parseInt(req.getParameter("age"));
    
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름=%s\n", name);//엔터에 0a 하나가 들어간다.
    out.printf("나이=%d\n",age);
    


  }

}

//get 요청 http 프로토콜 예)
//형식
//  method sp request-uri sp http_version CRLF
// *(general header | request header | entity header) crlf
// crlf
// message-body
//
//=>get 요청은 데이터를 request-uri에 붙여서 보낸다.
//=>request-uri 예)
//   /java-web/ex04/s1?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=20
//서블릿 url : /java-web/exo4/s1
//데이터 : name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=20
//=>데이터 형식
//이름=값&이름=값
//=> url 인코딩
// -데이터를 보낼 때 7bit 네트워크 장비를 거치면 8비트 데이터가 깨진다.
//이를 방시자고자 보내는 데이터를 7비트로 변환한다.
// -어떻게?
//원래 코드 값을 아스키(ASCII)문자 코드로 변환한다.
//-ASCII 코드는 7비트 이기 때문에 데이터를 주고 받을 때 꺠지지 않을 것이다.
//-url 인코딩이란? 문자 코드의 값을 ASCII 코드화 시키는 것이다.
//=>예) "ABC가각"을 전송한다고 가정하자
//"ABC가각"의 문자 코드(UTF-8) 값 : 414243EAB080EAB081
//ASCII 문자코드로 변환 :
//코드값이 이미 ASCII 라면 그대로
//41 ==>41
//42 ==> 42
//=> 코드 값이 ASCII가 아니라면 각 4비트 값을 ASCII문자라 간죽하고 코드로 변환한다.
// E==> 'E' ==>45
//A ==> 'A' ==>41
// 코드값 4 ==> ASCII 코드 '4' ==>34
//이렇게 변경한 후, URL 인코딩 값임을 표시하기 위해 앞에 
//'%' 코드를 붙인다.
// EA ==> 25 45 41 ==> 사람이 보는 문자로 표현하면 ==> %EA
//=>
/**
 * 
 * GET /java-web/ex04/s1?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=20 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*//*;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
 * 
 * 
 * 
 * */

//uri (uniform resource identifier)
//=>웹 자원의 위치를 가리키는 식별자
//=>종류
//url(uniform resource)
// scheme:[//[user:password@]]
//urn(uniform resource name)

//http 응답 프로토콜
//=>형식
//status-line(http프로토콜 상태코드 간단한 문구) CRLF
//*(general header | response header | entity header) crlf
//crlf
//message-body
//=>예
/**
 * HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 27
Date: Thu, 28 Mar 2019 05:46:08 GMT
crlf(빈줄)
name: 홍길동
age: 20
 * 
 * */

