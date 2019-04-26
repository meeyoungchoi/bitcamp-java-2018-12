// 세션 다루기 - @SessionAttributes
package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller 
@RequestMapping("/c03_2")

//request handler가 뷰 컴포넌트(jsp)에 전달하는 값 중에서
//세션에 보관할 값의 이름을 지정하며
//프론트 컨트롤러는 그 값을 HttpSession 객체에도 보관해 둔다.
//또한 @Attribute에서 지정한 이름의 값을 세션에서 꺼낼 때도 사용한다.
//즉 @SessionAttributes에 이름을 지정해 두지 않으면
//세션에 해당 값이 들어 있어도
//@ModelAttribute가 붙은 아규먼트에 값을 넣어주지 않는다.
//moddel어트리부트는 현재 페이지의 세션 어트리뷰트와 관게된 것이다.
@SessionAttributes({"name2","age2", "name", "age"}) //여기에 선언되어 있는것이 중요하다.
public class Controller03_2 {

  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c03_1?name=kim
  @GetMapping(value="h1", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(Model model) {

    //Modle 객체에 값을 담으면 프론트 컨트롤러는 ServletRequest 보관소에 값을 옮긴다.
    //만약 @SessionAttributes에서 지정한 이름의 값이라면
    //httpSession객체에도 보관된다.
    //HttpSession 객체를 사용하려면 아규먼트로 받아야 한다.
    //
    //세션에 값을 담고 싶다면 Model객체에 담으면 된다.
    //단 @SessionAtrributes에서 지정한 이름의 값만 세션에 자동으로 보괂된다.
    model.addAttribute("name2", "임꺽정");
    model.addAttribute("age2","30");

    //@SessionAttributes에 등록되지 않은 이름의 값은 세션에 보고나되지 않는다.
    //session에 담을 값은 @SessionAttribute를 사용한다.
    model.addAttribute("tel2", "1111-2222");
    return "세션에 값 보관했음";
  }
  

  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c03_1/h2
  //세션에 값을 꺼냈는데 없으면 nullㅇ이다.
  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2( HttpSession session) {
    return String.format("name2=%s, age2=%s, tel2=%s",
        session.getAttribute("name2"),
        session.getAttribute("age2"),
        session.getAttribute("tel2"));
  }



  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c03_1/h2
  //정말 세션에 값이 보관됬는지를 확인하기위해 출력
  //세션에서 꺼내고 싶은 값이 있으면 앞에 @ModelAttribute를 붙여라
  //세션에 보관되지 않은 값에 대해 @ModelAttribute를 붙이면 빈문자열이 리턴된다.
  //세션에 해당하는 값이 없으면 예외를 발생시킨다.
  @GetMapping(value="h3", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(/*HttpSession session*/
      //@ModelAttribute에 지정된 이름이 @SessionAttributes에 있는 경우
      //=> 세션에 해당 값이 있으면 아규먼트에 넣어준다.
      //=>세션에 해당 값이 없으면 예외가 발생한다.
      @ModelAttribute("name2") String name2,
      @ModelAttribute("age2") String age2,

      //@ModelAttribute에 지정된 이름이 @SessionAttributes에 없는 경우
      //=> 아규먼트에 빈 문자열을 넣어준다.
      //이 이름차제가 @SessionA에 적용된 이름이 아니므로 빈문자열을 뽀ㅂ아준다.
      //만약 요청 파라미터에 tel2 값이 있다면 그 값을 넣어준다.

      //세션에 값이 잌ㅆ으나 없으나 상관없이 아규먼트에 빈 문자열을 넣어준다.
      //만약 요청 파라미터에 tel2 값이 있다면 그 값을 넣어준다.
      @ModelAttribute("tel2") String tel2) {
    //세션어트리뷰트에 지정된 이름인 경우 파라미터에 사오간ㄴ없이 세션에서 꺼내서 준다.
    //만약에 파라미터가 있으면 빈문자열을 안주고 그 값을 꽂는다.
    //파라미터 값으로 tel2를 안넘겨주면 빈문자열이 출력된다.
    //모델어트리뷰트는 sessionAttribute에 지정된 값을 꺼낼때 사용한다.
    //얘는 세션에 값이 없으면 빈문자열인가보돠 하고 null을 맅턴한다.ㄴ

    return String.format("name2=%s, age2=%s, tel2=%s",
        name2, age2, tel2);
  }



  //테스트
  //1) c03_1/h1을 실행하여 name과 age값을 세션에 보관한다.
  //2) c03_2/h1을 실행하여 name2
  @GetMapping(value="h4", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler4(
      //c03_1/h1에서 세션에 젖아한 값 꺼내기
      //=>꺼내지 못한다. name과 age에는 빈 문자열이 저장된다.
      //=>왜?
      //@ModelAttribute는 현재 페이지 커트롤러의 @SessionAttributes에
      //지정된 이름에 한해서만 세션에서 값을 꺼내기 때문이다.
      @ModelAttribute("name") String name,
      @ModelAttribute("age") String age,
      
      //현재 컨트롤러에서 세션에 젖아한 값 꺼내기
      @ModelAttribute("name2") String name2,
      @ModelAttribute("age2") String age2){


    return String.format("name=%s, age=%s, name2=%s, age2=%s, tel2=%s",
        name, age, name2, age2);
  }

}













