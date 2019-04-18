//GET post 구분하기
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이 애노테이션을 붙인다.
@RequestMapping("/c02_1")
public class Controller02_1 {

  //테스트 방법:
  //=>http://localhost:8080/java-spring-webmvc.html/app1/c02_1.html
  
  @RequestMapping(method = RequestMethod.GET) //GET 요청일 때만 호출된다.
  @ResponseBody 
  public String handler1() {
    return "get";
  }
 
  @RequestMapping(method = RequestMethod.POST) //GET 요청일 때만 호출된다.
  @ResponseBody 
  public String handler2() {
    return "post";
  }
}
