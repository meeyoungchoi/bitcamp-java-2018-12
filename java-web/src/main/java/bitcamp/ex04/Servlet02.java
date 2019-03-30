//  클라이언트가 보낸 데이터 읽기 - post 요청 데이터 읽기
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
@WebServlet("/ex04/s2")
public class Servlet02 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    //post요청
    //-웹 페이지 폼에서 전송 버튼을 클릭하면 post 요청ㅇ르 보낸다.
    //
    //테스트
    //-/ex04/test01.html 실행
    //
    
    //웹 브라우저가 보낸 데이터 읽기
    //=>데이터를 읽을 때는 get요청과 post요청이 같다.
    //ServletRequest.getParameter("파라미터이름");
    //
    req.setCharacterEncoding("UTF-8");
    int age = Integer.parseInt(req.getParameter("age"));
    String name = req.getParameter("name");
    
    
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


//POST요청 HTTP 프로토콜 예)
//=>post 요청은 데이터를


/**
 * 
 * 
 * 
 * 
 * 
 * */


//get요청 vs post 요청
//1) 전송 데이터 용량
//=>get
// -request-uri
//-대부분의 웹서버가 rquest-line과 헤더의 크기를 8kb로 제한하고 있다.
//-따라서 긴 게시글과 같은 큰 용량의 데이터를 get 방식으로 전송할 수없다.
//=>post
//-http 요청 헤더 다음에 message-body 부분에 데이터를 두기 떄문에
//용량의 제한 없이 웹 서버에 전송할 수 있다.
//-즉 웹 서버가 제한하지 않는 한 전송 데이터의 크기에 제한이 없다.
//-웹 서버가 제한한다?
//네이버에서 메일을 전송할 떄 첨부 파일이 10MB 이상일 경우
//특정 사이트에서는 게시글의 크기나 첨부파일의 크기에 제한을 둔다.
//=>용도
// 게시글 조회나 검색어 입력 같은 간단한 데이터 전송에는 get요청으로 보내고
//게시글 등록이나 첨부파일 같은 큰 데이터 손송에는 post 요청으로 보낸다.
//
//2)바이너리 데이터 전송
//=>get
// -request-uri가 텍스트로 되어 있다.
// 따라서 바이너리 데이터를 request-uri에 붙여서 전송할 수 없다.
//-그럼에도 꼭 get 요청으로 바이너릴 데이터를 보내고자 한다면?
//바이너리 데이터를 텍스트로 변환하면 된다.
//예를 들어 바이너리 데이터를 Base64로 인코딩하여 텍스트를 만든 후에
//get요청 방식대로 이름=값 으로 보내면 된다.
//바이너리 데이터를 텍스트화 시킬때 사용하는 인토딩 방식 =>베이스64
//
//post
// -이 방식에도 이름=값 형태로는 바이너리 값을 전송할 수 없다.
// -multipart 형식을 상요하면 바이너리 데이터를 보낼 수 있다.
// -보통 파일 업로드를 구현할 때 이 multipart전송 방식으로 사용한다.
//
//3)get
//-url에 전송데이터가 포함되어 있기 때문에
//사용자 아이디나 암호 같은 데이터를 get 방식으로 전송하는 것은 위험하다.
//-웹 브라우저는 주소 창에 입력한 값을 내부 캐시에 보관해 두기 때문이다.
//-그러나 게시물 번호 같은 데이터를 url에 포함되어야 한다.
//그래야 다른 사람에게 url과 함께 데이터를 보낼수 있다.
//=>post
//   -message-body 부분에 데이터가 있기 때문에
//웹 브라우저는 캐시에 보관하지 않는다.
// -사용자 암호 같은 데이터를 전송할 때는 특히 이 방식읕로 보내는 것이 바람직 하다.
//그러나 꺼꾸로 특정 페이지를 조회하는 url일 경우 post 방식을 사용하면
//url에 조회라여는 정보의 번호나 키를 포함할 수 없기 때문에
//이런 상황에서는 post 방식이 적잘하지 않다.
//오히려 get 방식이 적합하다.






