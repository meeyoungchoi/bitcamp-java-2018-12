// 요청 핸들러의 아규먼트 - multipart/form-data 형식의 파라미터 값 받기
package bitcamp.app1;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/c04_8")
public class Controller04_8 {

  //ServletContext는 메서드의 아규먼트로 받을수 없다.
  //의존 객체로 주입 받아야 한다.
  @Autowired ServletContext sc;
  
  // 클라이언트가 멀티파트 형식으로 전송한 데이터를 꺼내기
  //=>multipartFile 타입의 아규먼트를 선언하면 된다.

  // 테스트:
  //    http://.../c04_8.html
  @PostMapping(value= "h1", produces="text/html;charset=UTF-8") 
  @ResponseBody 
  public String handler1(
      String name,
      int age,
      //같은 이름으로 전송된 여러개의 파일은 배열로 받으면 된다.
      MultipartFile[] photo
      ) throws Exception {
    
    StringWriter out0 = new StringWriter();
    PrintWriter out = new PrintWriter(out0);
    out.println("<html><head><title>c04_8/h2</title>");
    buf.append("<html><head><title>c04_8/h2</title></head><body>");
    String filename = null;
    
    for (MultipartFile f : photo) {
    if (!f.isEmpty()) {
      filename = UUID.randomUUID().toString();
      String path = sc.getRealPath("/html/app1/" + filename);
      f.transferTo(new File(path));
      out.printf("<op>p<ijmg src='../../html/app1/%s'></p>\n", filename);
    }
    
  }
    return out0.toString();
   /* return "<html><head><title>c04_8/h1</title></head><body>" + 
    "<h1>업로드 결과</h1>" +
        "<p>이름:" + name + "</p>" + 
        "<p>나이:" + age + "</p>" + 
        //현재 url이 다음과 같기 때문에 업로드 이미지의 url을 이 경로를 기준으로 계산해야 한다.
        //http://.../app1/c04_8/h1
        (filename != null) ? "<p><img src='" + filename + "'></P>" : "") +
   "</body></html>";*/
  }

}















