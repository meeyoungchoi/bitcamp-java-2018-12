//  멀티파으 파일 업로드 처리하기 - apache라이브러리 사용
package bitcamp.ex04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

// @WebServlet 애노테이션
//=>web.xml에 서블릿 정보를 설정하는 대신에
//이 애노테이션을 사용하여 서블릿을 설정할 수 있다.
//=>이 애노테이션을 활성화시키려명
//web.xml의 <web-app> 태그에 다음 속서을 추가해야 한다.
// metadata-complete="false"
//속성의 값은 false 여야 한다.
//하나의 이름에 서블릿이 두개 3개 있는건 안된다.
@WebServlet("/ex04/s4")
public class Servlet04 extends GenericServlet {

  private static final long serialVersionUID = 1L;
  private String uploadDir;//클라이언트가 누구든지 상관없이 이 변수를 바꾸지 않고 공유할 때는 상관없다.

  @Override
  public void init() throws ServletException {
    // init(ServletConfig)가 호출될 때 이 메서드도 호출된다.
    //=>upload/ 디렉토리에 해당 파일을 저장한다.
    //1) 파일을 저장할 경로를 준비한다.
    //ServletContext ctx;
    //String dirpath = this.getServletContext().getRealPath("/upload");//java-web이라는 context root를 의미한다.
    this.uploadDir =  this.getServletContext().getRealPath("/upload");
    //String filepath = "/home/meeyoungchoi/eclipse-workspace2/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/java-web";

  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    //멀티파트 형식으로 보낸 첨부 파일 데이터를 익는 방법
    //=>content-Type 헤더에 지정한 구분자를 사용하여 각 파트를 분리한 다음
    //데이터를 읽느느다.
    //=>문제는 기존에 제공하는 
    //
    //방법?
    //1) 개발자가 직접 멀티파트 형식을 분석하여 데이터를  추출한다(x)
    //2)외부 라이브러리를 사용히ㅏㄴ다.
    //-apache.org 사이트에서 제공하는 멀티파트 데이터 분석기를 사용한다,
    //-실무에서 예전에 많이 사용했다.
    //3)Servlet3.0 부터 제고앟는 기능을 이용한다,.
    // -실무에서 사요하던 그대로 계속 사용하는 바람에
    //서블릿에서 제공하는 방법을 갭라자들이 잘 사용하지 않는다.
    //또한 spring mb
    //-그것이 문제다.
    //4) Spring 

    //테스트
    //-/ex04/test04.html 실행
    //

    //웹 브라우저가 보낸 데이터 읽기
    //=>데이터를 읽을 때는 get요청과 post요청이 같다.
    //ServletRequest.getParameter("파라미터이름");
    //
    //getParameter()가 null을 리턴한다는 것을 확인하기 위해
    //파라미터 모두 String으로 받는다.
    //=>멀티파트 형식으로 전송된 데이터는 getParameter()로 꺼낼 수 없다.


    /*String age = req.getParameter("age");
    String name = req.getParameter("name");
    String photo = req.getParameter("photo");


    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름=%s\n", name);//엔터에 0a 하나가 들어간다.
    out.printf("나이=%s\n",age);

    //test03.html에서 파일을 전송할 때 multipart/form-date 형식이 아니기 때문에
    //첨부 파일의 데이터를 받을 수 없다.
    out.printf("사진=%s\n",photo);*/

    //멀티파트 형식의 데이터 처리하기
    //1) Apacher라이브러리 가져온다.
    //
    //
    //
    //
    //2)Apacher commons 

    //=>멀티파트 데이터를 분석하여 FileItem 객체에 담아줄 공장을 준비한다.
    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

    //=> 공장 객체를 사용하여 클라이언트가 보낸 데이터를 처리할 객체 준비
    ServletFileUpload multipartDataHandler = new ServletFileUpload(fileItemFactory);

    //분석한 
    HashMap<String,String> paramMap = new HashMap<>();

    try {
      //=>멀티파트 데이터 처리기를 이용하여 클라이언트 요청을 분석하기
      List<FileItem> parts = multipartDataHandler.parseRequest((HttpServletRequest)req);

      for (FileItem part : parts) {
        if (part.isFormField()) {
          //파트의 데이터가 일반 데이터라면
          paramMap.put(
              part.getFieldName(),
              part.getString("UTF-8")
              );
        } else {
          //파트의 데이터가 파일이라면
          //

          //업로드 파일을 저장할 때 사용할 파일명을 준비한다.
          //=>원래의 파일명을 사용하지 않는다.
          //=>다른 클라이언트가 같은 이름의 파일을 업로드 하면 기존 파일을 덮어쓸 수 있기 떄문이다.
          String filename = UUID.randomUUID().toString();

          //2) 전체 파일 경로를 준비한다.
          //=>/java-web/uploac/a.jpeg
          // File file = new File(this.uploadDir +"/" + part.getName());
          //uuid를 사용할 경우
          File file = new File(this.uploadDir + "/" + filename);

          //3) 파일 경로에 업로드 파일을 저장한다.
          part.write(file);

          // this.init();
          paramMap.put(
              part.getFieldName(),
              filename
              );

        }

      }//멀티파트 데이터를 처리할 때는 다음의 인토딩 설정이 적용되지 않는다.
      res.setContentType("text/html;charset=UTF-8");//
      PrintWriter out = res.getWriter();
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>servlet04</title>");
      out.println("</head>");
      out.println("<body><h1>파일 업로드 결과</h1>");

      out.printf("이름=%s<br>\n",paramMap.get("name"));
      out.printf("나이=%s<br>\n",paramMap.get("age"));
      out.printf("사진=%s<br>\n",paramMap.get("photo"));
      out.printf("<img src='../upload/%s'><br>\n", paramMap.get("photo"));
      out.println("</body></html>");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

//<form> 태그의 enctype을 "multipart/form-data"로 설정하면,
//웹 브라우저가 데이터를 전송할 떄 다음과 같은 형식으로 보낸다.

