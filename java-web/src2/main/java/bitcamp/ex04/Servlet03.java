//  클라이언트가 보낸 데이터 읽기 - 파일 업로드 처리하기
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
@WebServlet("/ex04/s3")
public class Servlet03 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    //post요청
    //-파일을 첨부하여 서버에 전송한다.
    //-multipart/form-data 형식으로 데이터를 전송하지 않으면
    //첨부 파일의 데이터는 받을 수 없다.
    //테스트
    //-/ex04/test03.html 실행
    //
    
    //웹 브라우저가 보낸 데이터 읽기
    //=>데이터를 읽을 때는 get요청과 post요청이 같다.
    //ServletRequest.getParameter("파라미터이름");
    //
    req.setCharacterEncoding("UTF-8");
    int age = Integer.parseInt(req.getParameter("age"));
    String name = req.getParameter("name");
    String photo = req.getParameter("photo");
    
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름=%s\n", name);//엔터에 0a 하나가 들어간다.
    out.printf("나이=%d\n",age);
    
    //test03.html에서 파일을 전송할 때 multipart/form-date 형식이 아니기 때문에
    //첨부 파일의 데이터를 받을 수 없다.
    out.printf("사진=%s\n",photo);
  }

}

//form의 기본 데이터 전송 형식은 "application/x-www-form-urlencoded"이다.
//즉 "이름=값&이름=값"
//
/*POST /java-web/ex04/s3 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 56
Cache-Control: max-age=0
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded =>이름 값 이름 값 이런식으로 출력한다.
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*//*;q=0.8
Referer: http://localhost:8080/java-web/ex04/test03.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
 * 
 * 
 * 
 * 
 * 
 * */





