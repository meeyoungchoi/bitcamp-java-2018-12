// 세션 다루기 - 세션의 값을 무효화 시키는 방법
package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller 
@RequestMapping("/c03_3")

//세션에 보관된 값 중에서 현재 페이지 컨트롤러에서 사요할 값을 지정한다.
//또한 세션에 보관할 값이기도 하다.
@SessionAttributes({"name", "name2"}) //페이지와 페이지사이에 임시 보관하는 값을 여기에 정의한다.
public class Controller03_3 {

  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c03_3/h1
  @GetMapping(value="h1", produces="text/plain;charset=UTF-8")
  @ResponseBody

  public String handler1( HttpSession session) {
    return String.format("name=%s, age=%s, name2=%s, age2=%s",
        session.getAttribute("name"),
        session.getAttribute("age"),
        session.getAttribute("name2"),
        session.getAttribute("age2"));

  }


  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(HttpSession session) {

    //현재 펭지 컨트롤러의 @Se
    //페이지와 페이지사이의 입력한 정보를 어딘가에 보관해야 하는데 이때 세션을 사용한다.
    //협소한 의미로 현재 페이지만 끝내겠다는 의이다.
    session.invalidate();

    return "status.setComplete()";
  }
  

  @GetMapping(value="h3", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(SessionStatus status) {

    //현재 펭지 컨트롤러의 @Se
    //페이지와 페이지사이의 입력한 정보를 어딘가에 보관해야 하는데 이때 세션을 사용한다.
    //협소한 의미로 현재 페이지만 끝내겠다는 의이다.
    //임시적으로 보관한 데이터 즉 sessionattributes에 남아잇는 값만 날아가게 된다.
    //임시적으로 보관된 데이터를 날릴때는 사용해도 된다,
    status.setComplete();

    return "status.setComplete()";
  }

}













