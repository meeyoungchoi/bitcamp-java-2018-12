// json 콘텐트 출력하기
package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

@Controller 
@RequestMapping("/c05_1")
public class Controller05_1 {

  ArrayList<Board> list = new ArrayList<>();
  
  public Controller05_1() {
    list.add(new Board(1, "제목이빈다.1", "내용입니다,1", "홍길동1", 10, Date.valueOf("2019-05-01")));
    list.add(new Board(2, "제목이빈다.2", "내용입니다,2", "홍길동2", 11, Date.valueOf("2019-06-01")));
    list.add(new Board(3, "제목이빈다.3", "내용입니다,3", "홍길동3", 12, Date.valueOf("2019-07-01")));
    list.add(new Board(4, "제목이빈다.4", "내용입니다,4", "홍길동4", 13, Date.valueOf("2019-08-01")));
    list.add(new Board(5, "제목이빈다.5", "내용입니다,5", "홍길동5", 14, Date.valueOf("2019-09-01")));
    list.add(new Board(6, "제목이빈다.6", "내용입니다,6", "홍길동6", 15, Date.valueOf("2019-10-01")));
    list.add(new Board(7, "제목이빈다.7", "내용입니다,7", "홍길동7", 16, Date.valueOf("2019-05-01")));
    list.add(new Board(8, "제목이빈다.8", "내용입니다,8", "홍길동8", 17, Date.valueOf("2019-05-01")));
    list.add(new Board(9, "제목이빈다.9", "내용입니다,9", "홍길동9", 18, Date.valueOf("2019-05-01")));
    list.add(new Board(10, "제목이빈다.10", "내용입니다,10", "홍길동10", 19, Date.valueOf("2019-05-01")));
    list.add(new Board(11, "제목이빈다.11", "내용입니다,11", "홍길동11", 11, Date.valueOf("2019-05-01")));
    list.add(new Board(12, "제목이빈다.12", "내용입니다,12", "홍길동12", 12, Date.valueOf("2019-05-01")));
    list.add(new Board(13, "제목이빈다.13", "내용입니다,13", "홍길동13", 13, Date.valueOf("2019-05-01")));
    
  }
  
  
  
  
  //1) jso에서 json형식의 콘텐트 출력하기
  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c05_1/h1
  @GetMapping("h1")
  public void handler1(Model model) {
     model.addAttribute("list", this.list);
 
  }

  
  //2) jso에서 json형식의 콘텐트 출력하기
  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c05_1/h1
  
  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2() {
    Gson gson = new Gson();
     return new Gson().toJson(this.list);
  }
  
  
  //3) Goolge Gson라이브러리를 사용하여 json 형식의 콘텐트 출력하기2.
  //=>페이지 컨트롤러의 리턴값이 String이 아니면
  //프론트 컨트롤러는  
  //Goolge 의 Gson 라이브러리나 jackson라이브러리를 사용하여
  //자동으로 json형식의 문자열로 만들어 클라이언트로 출력한다.
  //=>단 gson 또는 
  // 테스트:
  //   http://localhost:8080/java-spring-webmvc/app2/c05_1/h1
  @GetMapping("h3")
  @ResponseBody
  public Object handler3() {
   Gson gson = new Gson();
     return this.list;//json 형식의 문자열은 자동으로 utf-8로 인코딩 된다.
  }
}













