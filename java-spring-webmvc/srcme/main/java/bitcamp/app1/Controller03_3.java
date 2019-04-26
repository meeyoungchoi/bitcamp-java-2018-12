// request handler를 구분하는 방법 - 요청 헤더 이름으로 구분하기
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c03_3")
public class Controller03_3 {

  // 테스트 방법:
  // => http://localhost:8080/java-spring-webmvc/html/app1/c03_2.html
  //=>요청 헤더 주
  
  @GetMapping(produces = "text/plain")  //pagecontroller 입장 : 나 이런 데이터 만들어 줄수 있어요
  @ResponseBody 
  public String handler1() {
    return "handler1";
  }
  
  @GetMapping(produces = "text/html") 
  @ResponseBody 
  public String handler2() {
    return "handler2";
  }
  
  @GetMapping(produces = "application/json") 
  @ResponseBody 
  public String handler3() {
    return "handler3";
  }
  
  @GetMapping
  @ResponseBody 
  public String handler4() {
    return "handler4";
  }
}
