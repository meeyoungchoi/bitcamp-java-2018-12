package com.eomcs.lms.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component("/auth/logout")
public class LogoutController implements PageController {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {



    // 세션을 무효화시킨다.
    request.getSession().invalidate();

    //뷰 컴포넌트의 url을 ServletRequest 보관소에 저장한다.
    return "redirect:" + request.getServletContext().getContextPath();
  }
}










