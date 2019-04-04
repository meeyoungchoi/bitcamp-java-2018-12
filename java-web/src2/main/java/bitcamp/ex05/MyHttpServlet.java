package bitcamp.ex05;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 클래스를 만들 때 HTTP 프로토콜을 쉽게 달루 수 있돌고
//service(HttpServletRequest, HttpServletResponse) 메서드를 추가하였다.
//따라서 GenericServlet을 상속 받아서 서블릿을 만ㄷ르기 보다
//MyHttpServlet 클래스를 상속받아 서블릿을 만들면
//훨씬 편하게 serive()를 구현할 수 있다.


@SuppressWarnings("serial")
public abstract class MyHttpServlet extends GenericServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    //서블릿 컨테이너가 service 메서드를 호출하면
    
    //=>파마미터 값을 원래의 타입으로 변환한다.
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    
    //오버로딩 한 service()를 호출한다.
    this.service(request, response);
    
  }

  protected void service(
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
  } 
}

  

