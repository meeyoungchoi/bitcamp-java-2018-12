package com.eomcs.lms.controller;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;


@Controller("/auth/login")
public class LoginController implements PageController {

  static final String REFERER_URL = "refererUrl";
  
  @Autowired MemberService memberService;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    if (request.getMethod().equals("GET")) {
      HttpSession session = request.getSession();
      session.setAttribute(REFERER_URL,request.getHeader("REFERER"));
    }
    
    ServletContext sc = request.getServletContext();
    
    // 이메일 저장을 처리한다. 
    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15); // 15일간 쿠키를 보관한다.
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0); // 기존의 쿠키를 제거한다.
    }
    //이제 이 클래스는 including 서블릿이 아니기 때문에
    //프론트 컨트롤러에서 받은 response 객체 사용하여
    
    response.addCookie(cookie);
    
   
    Member member = memberService.get(
        request.getParameter("email"),
        request.getParameter("password"));
    
    if (member == null) {
      response.setContentType("text/html;charset=UTF-8");
      return  "/auth/fail.jsp";
      
    }
    
    HttpSession session = request.getSession();
    
    // 세션에 로그인 사용자의 정보를 보관한다.
    session.setAttribute("loginUser", member);
    
    // 로그인 성공하면 다시 메인 화면으로 보낸다.
    String refererUrl = (String) session.getAttribute(REFERER_URL);
    if (refererUrl == null) {//뷰 컴포넌트의 url을 ServletRequest보관소에 저장한다.
      return "redirect:" + sc.getContextPath();
    } else {
      return "redirect:" + refererUrl;
    }
  }
}










