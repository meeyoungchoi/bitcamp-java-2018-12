package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {



  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    String pageControllerPath = request.getPathInfo();

    //클라이언트가 요청한 서블릿을 실햏아한다.
    request.getRequestDispatcher(pageControllerPath).include(request, response);

    if (request.getAttribute("error.title") != null) {
      request.getRequestDispatcher("/error.jsp").forward(request, response);
      return;
    }

    //ServletRequest 보관소에 저장된 view 컴포턴트 url을 꺼낸다.
    String viewUrl = (String) request.getAttribute("viewUrl");

    if (viewUrl.startsWith("redirect:")) {
      response.sendRedirect(viewUrl.substring(9));
    } else {
      //페이지 컨트롤러가 알려준 jsp를 실행한다.
      response.setContentType("text/html;charset=UTF-8");

      if (request.getAttribute("error.title") != null) {
        request.getRequestDispatcher(viewUrl).include(request, response);
      }

      request.getRequestDispatcher(viewUrl).include(request, response);
    }

  }
}
