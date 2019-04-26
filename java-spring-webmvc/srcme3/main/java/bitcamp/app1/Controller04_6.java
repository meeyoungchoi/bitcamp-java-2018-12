// 요청 핸들러의 아규먼트 - @ReqeustHeader
package bitcamp.app1;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_6")
public class Controller04_6 {

  // 클라이엉ㄴ트의 http 요청 헤더를 받고 싶으면
  //request handler의 아규먼트 앞에 @ReqeustHeader(헤더명) 애노테이션을 붙여라

  // 테스트:
  //    http://.../c04_6/h1?model=sonata&capacity=5&auto=true&createdDate=2019-4-19
  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
      PrintWriter out,

      @RequestHeader("Accept") String accept,
      @RequestHeader("User_agent") String userAgent
      ) {

    out.printf("accept=%s\n", accept);
    out.printf("userAgent=%s\n", userAgent );
    userAgent.indexOf("Chrome");
    
    //filter에 주로 둔다.
    //유용한 사이트가 아니면 튕겨내는 역할
    if (userAgent.matches(".*Chrome.")) {
      out.println("chrome");
    } else if (userAgent.matches(".*Firefox.")) {
      out.println("FireFox");
    } else {

      out.println("etc");
    }

  }

  public static void main(String[] args) {
    String str ="Mozilia/5.0 (Machintosh; Intel Mac OS X 10_13_6) AppleWeb chrome";
    //String str = "AA BB Aa Ba $12,000";
    // String regex = "Chrome";
    // String regex = "Safari";
    String regex = "^(Chrome).*Safari";
    Pattern pattern = Pattern.compile(regex);

    //주어진 문자열에서 패턴과 일치하는 정보를 찾는다.
    Matcher matcher = pattern.matcher(str);

    //일치 여부를 확인한다.
    if (matcher.find()) {
      System.out.println("ok!");
      //문자열을 꺼내다.
      //for (int i = 0; i < matcher.groupCount(); i++) {
      //System.out.println(matcher.group(1));
      //}
    }

  }

}















