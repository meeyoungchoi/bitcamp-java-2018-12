// url에서 값 추출하기 - @PathVariable
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c02_1")
public class Controller02_1 {

  
  //테스트:
  //http://localhost:8080/java-spring-webmvc/app2/c02_1/h1?name=kim&age=20
  @GetMapping("h1") 
  @ResponseBody
  public String handler1(String name, int age) {//servlet request 나 map 보다는 model에 많이 담는다.
  
    //클라이언트에서 값을 받는 일반적인 방법
    //=>Query String 으로 받는다.
    //=>즉 url 다음에 "?변수=값&변수=값" 형태로 값을 받는다.
    //
    ///
    //
    
    return String.format("name=%s, age=%d", name, age );
  }
  
  //테스트:
  //http://localhost:8080/java-spring-webmvc/app2/c02_1/h2/kim/20
  @GetMapping("h2/{name}/{age}") 
   @ResponseBody
  public String handler2(
      @PathVariable("name") String name,
      @PathVariable("age") int age
      ) {
    
    //url에 값을 포함하여 전달할 수 있고, 그 값을 아규먼트로 받을 수 있다.
    //url에 포함되니 값을 받으려면 request handler의 url을 설정할 때
    //다음의 문법으로 선언해야 한다.
    //=>.../{변수명}/{변수명}
    //이렇게 선언된 변수 값을 받으려면 다음과 같이 아규먼트를 선언해야 한다.
    //=>@PathVariable(변수명) String 아규먼트
    
    return String.format("name=%s, age=%d", name, age ); //이렇게 하면 못받는다.
  
  }
  
  
  
  //테스트:
  //http://localhost:8080/java-spring-webmvc/app2/c02_1/h2/kim/20
  @GetMapping("h3/{name}/{age}") 
   @ResponseBody
  public String handler3(
      @PathVariable("name") String name,
      @PathVariable("age") int age
      ) {
    
    //url에 값을 포함하여 전달할 수 있고, 그 값을 아규먼트로 받을 수 있다.
    //url에 포함되니 값을 받으려면 request handler의 url을 설정할 때
    //다음의 문법으로 선언해야 한다.
    //=>.../{변수명}/{변수명}
    //이렇게 선언된 변수 값을 받으려면 다음과 같이 아규먼트를 선언해야 한다.
    //=>@PathVariable(변수명) String 아규먼트
    
    return String.format("name=%s, age=%d", name, age ); //이렇게 하면 못받는다.
  
  }
  
 
  
}





