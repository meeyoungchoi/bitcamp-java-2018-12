//페이지 컨트롤러 만드는 방법 - 한 객의 페이지 컨트롤러에 여러개의 요청 핸들러 두기
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이 애노테이션을 붙인다.
@RequestMapping("/c01_3")
public class Controller01_3 {

  @RequestMapping("h1") //핸들러에 적용될 기본 url을 지정한다,
  @ResponseBody // 메서드의 리턴 값이 클라이언트에게 출력할 내용임을 설정한다.
  public String handler1() {
    return "h1";
  }
  
  
  
  @RequestMapping("/h2")//
  @ResponseBody 
  public String handler2() {
    return "h2";
  } 
  
  @RequestMapping("h3") 
  @ResponseBody 
  public String handler3() {
    return "h3";
  } 
  
  @RequestMapping("h4") 
  @ResponseBody 
  public String handler4() {
    return "h4";
  } 
  
  
  
}
