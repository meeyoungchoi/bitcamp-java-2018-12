// view Resolver교체하기
package bitcamp.app2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/c01_1")
public class Controller01_1 {

  
  //테스트:
  //http://l
  @GetMapping("h1") 

  public String handler1(Model model) {//servlet request 나 map 보다는 model에 많이 담는다.
    
    model.addAttribute("name", "홍길동");
    model.addAttribute("age", "20");
    
    
    //InternalResourceViewResolver를 사용하여
    //jsp url의 접두어와 접미사를 미리 설정해 둘 수 있다.
    //그러면 request handler에서 jsp 전체 url을 짖어할 필요가 없어 편리하다.
    //=>app2-servlet.xml을 참고하라
    // view resolver를 교체한 태그가 있을 것이다.
    
    //프론트 컨트롤러는 request handler가 리턴한 url을 
    //view resolver에게 전달한다.
    //view resolver는 자신의 정책에 맞춰서 해당 url을 처리한다.
    //=>InternalResourceViewReslolver의 경우
    //request handler가 리턴한 url앞, 뒤에
     //접두사와 접미사를 붙여 jsp를 찾는다.
    //예를들어 다음 url을 리턴하면
    //최종 jsp url은 "/web-inf/jsp2"
    return "c01_1/h1"; 
  }
  
  //테스트:
  //http://l
  @GetMapping("h2") 

  public void handler2(Model model) {
    
    model.addAttribute("name", "홍길동2");
    model.addAttribute("age", "30");
    //internal resource vie resolver를 사용하는 경우,
    //request handler가 값을 리턴하지 않으면
    //request handler의 url을 리턴 값으로 사용하낟.
    //즉 이 핸들러의 url은 "/c01_1/h2"이다.
    //따라서 최종 Jsp url은 "/web-inf/jsp2/" + "/c01_1/h2" + ".jsp"이다.
    // => "/WEB-INf/jsp2/c01_1/h2.jsp"
    //
    //그래서 실무에서는 이 방법을 많이 사용한다.
    
  }
  
  
  @GetMapping("h3") 
  public Map<String,Object> handler2() {
    
    HashMap<String,Object> map = new HashMap<>();
    map.put("name", "홍길동3");
    map.put("age", "40");
    
    
    //Map 객체에 값을 담아 리턴하면
    //프론트 컨트롤러는 
    //뷰 url은 map객체를 만들어서 값을 만들어서 리턴한다.
    
    return map;
    
  }
  
}





