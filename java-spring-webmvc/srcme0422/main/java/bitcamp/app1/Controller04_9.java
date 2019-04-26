// 요청 핸들러의 아규먼트 - @RequestBody
package bitcamp.app1;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_9")
public class Controller04_9 {

  // 클라이엉ㄴ트가 보낸 데이터를 통째로 받기
  // 의존 객체로 주입 받아야 한다.
  @Autowired ServletContext sc;
  
  // 클라이언트가 멀티파트 형식으로 전송한 데이터를 꺼내기
  // => MultipartFile 타입의 아규먼트를 선언하면 된다.
  
  // 테스트:
  //    http://.../html/app1/c04_9.html
  @PostMapping(value="h1", produces="text/html;charset=UTF-8") 
  @ResponseBody 
  public String handler1(
      String name,
      int age,
      //클라이언트가 보낸 데이터를 통쨰로 받으려면 @RequestBody 애노테이션을 붙이면 된다.
      @RequestBody String data
      ) throws Exception {
    
    StringWriter out0 = new StringWriter();
    PrintWriter out = new PrintWriter(out0);
    out.println("<html><head><title>c04_8/h2</title></head><body>");
    out.println("<h1>업로드 결과</h1>");
    out.printf("<p>이름:%s</p>\n", name);
    out.printf("<p>나이:%s</p>\n", age);
    out.printf("<p>통데이터:%s,%s</p>\n", age, name);
    
    return out0.toString();
  }

}










