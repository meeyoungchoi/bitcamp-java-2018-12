// 요청 핸들러의 아규먼트 - 글로벌 프로퍼티 에디터 적용하기
package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_5")
public class Controller04_5 {

  // 다른 페이지 컨트롤러에서 등록한 프로퍼티 에디터는 사용할수 없다.
  //각 페이지 컨트롤러 

  //글로벌 프로퍼티 에디터 등록하기
  //@ControllerAdvice애노테이션이 붙은 클래스에서
  //@InitBinder 메서드를 정의하면 된다.
  //=>GlobalControllerAdvice 클래스를 참고하라!

  // 테스트:
  //    http://.../c04_4/h1?model=sonata&capacity=5&auto=true&createdDate=2019-4-19
  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      String model,
      int capacity, 
      boolean auto,
      Date createdDate
      ) {

    out.printf("model=%s\n", model);
    out.printf("capacity=%s\n", capacity);
    out.printf("auto=%s\n", auto);
    out.printf("createdDate=%s\n", createdDate);
  }

  //테스트:
  //    http://.../c04_4/h2?car=sonata,5,true,2019-4-19
  @GetMapping("h2") 
  @ResponseBody   PrintWriter out,

  @RequestParam("Engine") Engine engine

  ) {
out.println(engine);
}
  public void handler2(
      PrintWriter out,
      // 콤마(,)로 구분된 문자열을 Car 객체로 변환하기?
      // => String ===> Car 프로퍼티 에디터를 등록하면 된다.
      @RequestParam("car") Car car
      ) {

    out.println(car);
  }

  @GetMapping("h3") 
  @ResponseBody 
  public void handler3(
      PrintWriter out,

      @RequestParam("Engine") Engine engine

      ) {
    out.println(engine);
  }



}












