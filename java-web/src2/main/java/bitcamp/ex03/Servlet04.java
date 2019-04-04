//  클라이언트로 출력하기 - 바이너리 데이터 출력하기
package bitcamp.ex03;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
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
@WebServlet("/ex03/s4")
public class Servlet04 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    // /web-inf/photo.jpeg 실제 경로 알아내기
    //1) 서블릿의 환경 정보를 다루는 객체를 먼저 얻는다.
    ServletContext ctx = req.getServletContext();
    
    //2) ServletContext를 통해 웹 자원의 실제 경로를 알아낸다.
    //=>getRealPath()
    String path = ctx.getRealPath("/WEB-INF/photo.jpeg");
    
    FileInputStream in = new FileInputStream(path);
    
    //바이너리를 출력할 때 MIME 타입을 
    //=>웹 브라우저가 모르는 형식을 지정하면 웹 브라우저는 처리하지 못해
    //그냥 다운로드 대화상자를 띄운다.
    res.setContentType("image/jpeg"); //utf-16 ==> utf-8
    
    BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());
    
    //PrintWriter out = res.getWriter();
    
    int b;
    while ((b = in.read()) != -1) {
      out.write(b);
    }
   
    out.flush();//버퍼 데코레이터에 보관된 데이터르를 클라이언트로 방출한다,.
    in.close();
    


  }

}
