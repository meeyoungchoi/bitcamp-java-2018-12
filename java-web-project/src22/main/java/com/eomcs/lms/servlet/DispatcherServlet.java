package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.controller.PageController;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@WebServlet("/app/*")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

  @SuppressWarnings("unchecked")
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String pageControllerPath = request.getPathInfo();

    // 클라이언트가 요청한 페이지 컨트롤러를 실행한다.
    //=>Spring Ioc 컨테이너를 꺼낸다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");

    try {
      //=>Spring IoC 컨테이너에서 클라이언트가 요청한 url을 처리할  페이지 컨트롤러를 꺼낸다.
      PageController pageController = (PageController) iocContainer.getBean(pageControllerPath);

      //=>페이지 컨트롤러 실행
      String viewUrl = pageController.execute(request, response);
      
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        //페이지 컨트롤러가 알려준 jsp를 실행한다.
        request.getRequestDispatcher(viewUrl).include(request, response);
      }
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.setAttribute("error.title", "요청을 처리 오류!.");
      request.setAttribute("error.content", e.getMessage());
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
