package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/search")
@SuppressWarnings("serial")
public class MemberSearchServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer"))
            .getBean(MemberService.class);
    response.setContentType("text/html;charset=UTF-8");

    String keyword = request.getParameter("keyword");
    List<Member> members = memberService.list(keyword);

    request.setAttribute("keyword", members);

    RequestDispatcher rd = request.getRequestDispatcher("/member/search.jsp");
    rd.include(request, response);
  }

}