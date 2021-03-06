// 요청 핸들러의 아규먼트 - view url 리턴하기, 리다이렉트 , forward/include
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

@Controller 
@RequestMapping("/c05_2")
public class Controller05_2 {

  
  //테스트:
  //http://l
  @GetMapping("h1") 

  public String handler1() {
    //메서드 선언부에 @ResponseBody를 붙이징 낳으면
    //프론트 컨트롤러는 view url로 간주한다.
    //=>리턴 url의 '/'는 
    //=>webapp 밑에 jsp를 두면 안된다.
    return "/jsp/c05_2.jsp";
    
  }
  
  
  //테스트:
  //http://l
  @GetMapping("h2") 

  public String handler2() {
    //메서드 선언부에 @ResponseBody를 붙이징 낳으면
    //프론트 컨트롤러는 view url로 간주한다.
    //=>리턴 url의 '/'는 
    //mvc 패턴에서는 항상 Controller에 의해 view가 통제되어야 한다.
    // Controller를 경유하지 않고 View를 실행하게 해서는 안된다.
    //그래야 view에 대해 일관성 있는 제어가 가능하다.
    // 문제는 jsp 파일을  web 애플리케이션의 일반 폴더에 두게 되면
    //다음과 같이 클라이언트에서 직접 실행을 요청할 수 있다.
    //http://localhost:8080/java-spring-webmvc/WEB-INF/jsp/c05_2.jsp
    //이것을 막으려면 , 다음과 같이 web-inf폴터 밑에 jsp 파일을 두어라
    // /web-inf/폴더에 있는 파일은 크리이언트에서 직접 실행을 요청할 수 없다.
    //프론트컨트롤러ㅇ의 통제없이 jsp를 바로 실행하지 못하게 하기 위함이다.
    
   return "/WEB-INF/jsp/c05_2.jsp";
    
  }
 
  //테스트:
  //http://l
  @GetMapping("h3") 

  public View handler3() {
   return new JstlView("/WEB-INF/jsp/c05_2.jsp");
    
  }
  
  //테스트:
  //http://localhost:8080/java-spring-webmvc/app1/c05_2/h4
  @GetMapping("h4") 

  public ModelAndView handler4() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/WEB-INF/jsp/c05_2.jsp");
    return mv;

    
  }
  
  //테스트:
  //http://l
  @GetMapping("h5") 

  public String handler5() {
    //리다이렉트를 짖어할 때는 url 앞에 "redirect"접
    //즉 http 응답이 다음과 같다.
    /*
     * 
     * 
     * 
     * 
     * 
     * 
     * */
    return "redirect:h4";

    
  }
  
  //테스트:
  //http://l
  @GetMapping("h6") 

  public String handler6() {
    //포워드를 지정할 때는 url앞에 "forward:" 접두어를 붙인다.
    //인클루드를 지정할 때는 url 아ㅠ에 include접두어를 붙인다.
    return "forward:h4";
  }
}





