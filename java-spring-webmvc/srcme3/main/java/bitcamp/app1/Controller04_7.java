// 요청 핸들러의 아규먼트 - 
package bitcamp.app1;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_7")
public class Controller04_7 {

  // 클라이엉ㄴ트의 http 요청 헤더를 받고 싶으면
  //request handler의 아규먼트 앞에 @ReqeustHeader(헤더명) 애노테이션을 붙여라

  // 테스트:
  //    http://.../c04_6/h1?model=sonata&capacity=5&auto=true&createdDate=2019-4-19
  @GetMapping("h2") 
  @ResponseBody 
  public void handler2(
      PrintWriter out,
      @CookieValue(value= "name1", required=false) String name1,
      @CookieValue(value= "name2", defaultValue="") String name2,
      @CookieValue(value="age", defaultValue="0") int age
      ) {

    out.printf("name1 = %s\n", name1);
    out.printf("name2=%s\n", name2);
    out.printf("age=%d\n", age);
  }

}















