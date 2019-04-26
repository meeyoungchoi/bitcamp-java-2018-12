//페이지 컨트롤러 만드는 방법 - 기본 url과 상세 url을 설정하는 방법
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이 애노테이션을 붙인다.
public class Controller01_2 {

  @RequestMapping("/c01_2/h1") //핸들러에서 url을 지정한다.
  @ResponseBody // 메서드의 리턴 값이 클라이언트에게 출력할 내용임을 설정한다.
  public String handler1() {
    return "/c01_2/h1";
  }
  
  
  
  @RequestMapping("/c01_2/h2") 
  @ResponseBody 
  public String handler2() {
    return "/c01_2/h2";
  } 
  
  @RequestMapping("/c01_2/h3") 
  @ResponseBody 
  public String handler3() {
    return "/c01_2/h3";
  } 
  
  @RequestMapping("/c01_2/h4") 
  @ResponseBody 
  public String handler4() {
    return "/c01_2/h4";
  } 
  
  
  
}
