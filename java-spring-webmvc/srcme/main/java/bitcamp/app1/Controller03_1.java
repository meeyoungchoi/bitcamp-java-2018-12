//파라미터 이름으로 requestHandler 구분하기기
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이 애노테이션을 붙인다.
@RequestMapping("/c03_1")
public class Controller03_1 {

  //테스트 방법:
  //=>http://localhost:8080/java-spring-webmvc/app1/c03_1?name=kim
  
  @GetMapping(params = "name") //GET 요청일 때만 호출된다.
  @ResponseBody 
  public String handler1() {
    return "handler1";
  }
 
  //테스트 방법:
  //=>http://localhost:8080/java-spring-webmvc/app1/c03_1?age=20
  @GetMapping(params = "age") //GET 요청일 때만 호출된다.
  @ResponseBody 
  public String handler2() {
    return "handler2";
  }
  
  //테스트 방법:
  //=>http://localhost:8080/java-spring-webmvc/app1/c03_1?age=20
  @GetMapping(params = {"age", "name"}) //GET 요청일 때만 호출된다.
  @ResponseBody 
  public String handler3() {
    return "handler2";
  }
}
