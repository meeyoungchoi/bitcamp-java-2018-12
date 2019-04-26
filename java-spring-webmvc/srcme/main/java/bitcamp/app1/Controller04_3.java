// 요청 핸들러의 아규먼트 - @RequestParam  요청핸들러의 변수는 아규먼트라 한다.
//- 도메인 객체(=값 객체; value objecct)로 요청 파라미터 값 받기
package bitcamp.app1;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_3")
public class Controller04_3 {
  
  //클라이언트가 보낸 요청 파라미터 값을 값 객체에 받을 수 있다.
  
  //=>값 객체의 프로퍼티 이름과 일치하는 요청 파라미터가 있다면
  //
  //=> 요청 핸들러의 아규먼트가 값 객체라면 ,
  //  프론트 컨트롤러는 메서드를 호출할 떄 값 객체의 인스턴스를 생성한 후 
  // 요청 파라미터와 일치하는 프로퍼티에 대해 값을 저장한다.
  //그리고 호출할 때 넘겨 준다. 그외 숫자는 예외 발생!

  //테스트:
  // http://.../app1/c04_3/h1?model=sonata&maket=hyundai&capacity=5&auto=true
 
  @PostMapping("h1") 
  @ResponseBody 
  public void handler1(
     PrintWriter out,
     String model,
     String maker,
     int capacity, // 프론트 컨트롤러가 String 값을 int로 변환해 준다.
     //단 변환할 수 없을 
     boolean auto, //단 변환할수 없을 경우 예외가 발생한다.
     //"true", "false"는 대소문자 구분없이 true, false로 변환해 준다.
     
     Car car //아규먼트가 값 객체이면 요청 파라미터 중에서 값 객체의 프로퍼티 이름과 일치하는 
     // 항목에 대해 값을 넣어준다. 
     //값 객체 안에 또 값 객체가 있을 때는 ognl방식으로 요청 파라미터 값을 지정하면 된다.
     //value객체 안에 있는 value객체의 값을 넣을때
     //$객체명.프로퍼티명
     //예)h1?model=sonata&engine.model=ok&engine.cc=1980&engine.valuve=16
     //engine의 이름은 car객체의 프로퍼티명과 일치해야 한다.
    
      ) {
    
    out.printf("model=%s\n", model);
    out.printf("maker=%s\n",maker);
    out.printf("capacity=%s\n",capacity);
    out.printf("auto=%s\n",auto);
    out.printf("car=%s\n",car);
    
  }

 

}
