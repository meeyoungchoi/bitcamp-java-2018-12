package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import com.eomcs.lms.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    String contextRootPath = getServletContext().getContextPath();

    PrintWriter out = response.getWriter();
    out.println("<header>");
    out.println("  <img src='http://bitcamp.co.kr/img/logo.jpg' style='height:50px'>");
    if (loginUser == null) {
      out.printf("<a href='%s/auth/login'>로그인</a>", contextRootPath);
    } else {
      out.printf("<img src = ''>%s' stype='height:20px;'> %s",
          loginUser.getPhoto(),
          loginUser.getName());
      out.printf("<a href='%s/auth/logout'>로그아웃</a>",
          contextRootPath);
    }
    out.println("</header>");

  }

}










