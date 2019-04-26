package com.eomcs.lms.web;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
@RequestMapping("/auth")
@SessionAttributes({"loginUser", "refererUrl"}) //항목이 여러개일 때는 배열을 의미하는 {}를 반드시 적어야 한다.
public class AuthController {

  static final String REFERER_URL = "refererUrl";

  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;
  
  @GetMapping("form")
  public void form(
      @RequestHeader(value="Referer",required=false) String refererUrl,
      Model model) {
    model.addAttribute(REFERER_URL, refererUrl);

  }
  
  @PostMapping("login")
  public String login(
       String email,//@ReeuqestParam을 아애 생략해도 된다.
       String password,
      String saveEmail,
      HttpSession session,
      HttpServletResponse response) throws Exception {

    // 이메일 저장을 처리한다. 
    Cookie cookie;
    if (saveEmail != null) {
      cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 15); // 15일간 쿠키를 보관한다.
      
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0); // 기존의 쿠키를 제거한다.
    }

    // 이제 이 클래스는 including 서블릿이 아니기 때문에 
    // 프론트 컨트롤러에서 받은 response 객체를 사용하여 
    // 바로 쿠키를 추가할 수 있다.
    response.addCookie(cookie); 

    Member member = memberService.get(email, password);

    if (member == null) {
      return "auth/fail";
    }

    session.setAttribute("loginUser", member);

    String refererUrl = (String) session.getAttribute(REFERER_URL);
    if (refererUrl == null) {      
      return "redirect:" + servletContext.getContextPath();
      
    } else {
      return "redirect:" + refererUrl;
    }
  }
  
  @GetMapping("logout")
  public String logout(HttpSession session) throws Exception {
    session.invalidate();
    return "redirect:../../";
  }
}










