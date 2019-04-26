// 요청 핸들러에서 view 컴포넌트(jsp) 쪽에 데이터 전달하기
package bitcamp.app1;

import java.util.Map;
import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/c05_3")
public class Controller05_3 {

  
  //테스트:
  //http://l
  @GetMapping("h1") 

  public String handler1( 
    ServletRequest request) {
    
    //
    request.setAttribute("name", "홍길동"); //서블릿 리케스트에 보관했다가 jsp가 꺼내쓴다. 저장소이다.
    request.setAttribute("age", 20); //auto-boxing
    request.setAttribute("working",true);
    return "/WEB-INF/jsp/c05_3.jsp";
    
  }
  
  
  //테스트:
  //http://l
  @GetMapping("h2") 
  public String handler2(Map<String, Object> map ) {
    
    //아규먼트의 Map타입을 변수로 선언하면
    //프론트 컨트롤러는 맵 객체를 만들어 넘겨준다.
    //이 맵 객체의 용도는 jsp에 전달할 값을 담는 용이다.
    //맵 객체에 값을 다아 놓으면 프론트 컨트롤럴가 jsp를 실행하기 전에
    //ServletRequest로 복사한다.
    //따라서 ServletRequest에 값ㅇ르 담는 것과 같다.
    //
    map.put("name", "홍길동");
    map.put("age", 20); //auto-boxing
    map.put("working",true);
    
    return "/WEB-INF/jsp/c05_3.jsp";
    
  }
  
  //테스트:
  //http://l
  @GetMapping("h3") 
  public String handler3(Model model ) {
    
    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20); //auto-boxing
    model.addAttribute("working",true);
    
    return "/WEB-INF/jsp/c05_3.jsp";
    
  }
  
  //테스트:
  //http://l
  @GetMapping("h4") 
  public String handler4(Model model ) {
    //re
    ModelAndView mv = new ModelAndView();
    
    //jsp가 사용할 데이터를 담고
    model.addObject("name", "홍길동");
    model.addObject("age", 20); //auto-boxing
    model.addObject("working",true);
    
    mv.set
    return "/WEB-INF/jsp/c05_3.jsp";
    
  }
}





