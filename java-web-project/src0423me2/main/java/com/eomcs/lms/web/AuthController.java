package com.eomcs.lms.web;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
@RequestMapping("/auth")
public class AuthController {

 //final static Logger logger = LogManager.getLogger(AuthController.class);
  static final String REFERER_URL = "refererUrl";

  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;

  @GetMapping("form")
  public void form(
      @RequestHeader(value="Referer",required=false) String refererUrl,
      HttpSession session) {
    
    //logger.debug("refererUrl:" + refererUrl);
    if (refererUrl != null && !refererUrl.endsWith("/auth/login")) {
      session.setAttribute(REFERER_URL, refererUrl);
    } else {
      session.removeAttribute(REFERER_URL);

    }
  }

  @PostMapping("login")
  public String login(
      String email,
      String password,
      String saveEmail,
      HttpSession session,
      HttpServletResponse response) throws Exception {

    Cookie cookie;
    if (saveEmail != null) {
      cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 15); // 15일간 쿠키를 보관한다.

    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0); // 기존의 쿠키를 제거한다.
    }
    response.addCookie(cookie); 

    Member member = memberService.get(email, password);

    if (member == null) {
      return "auth/fail";
    }

    session.setAttribute("loginUser", member);

    String refererUrl = (String) session.getAttribute(REFERER_URL);
   // logger.debug("refererUrl:" + refererUrl);
    if (refererUrl  != null) {      
      return "redirect: /";// /는 현재 웹 어플리케이션 루트를 의미한다. 
      //즉 컨텍스트 루트를 의미한다.
      //스프링 웹 mvc의 프론트 컨트롤러가 이 루트를 받느느다.
    } else {

      response.sendRedirect(refererUrl);
      return null;
      //return "redirect:" + refererUrl; =>상태경로는 대지만 절대경로가 되지 못한다.
    }
  }

  @GetMapping("logout")
  public String logout(HttpSession session) throws Exception {
    
    //logger.debug("세션 무효화 시킴!");
    //logger.debug("loginUser: " + session.getAttribute("loginUser"))
    session.invalidate();
   
    return "redirect:/";
  }
}










