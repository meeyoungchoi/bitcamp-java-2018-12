package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/search")
@SuppressWarnings("serial")
public class MemberSearchServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = InitServlet.iocContainer.getBean(MemberService.class);
    response.setContentType("text/html;charset=UTF-8");

    String keyword = request.getParameter("keyword");
    List<Member> members = memberService.list(keyword);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>회원 목록</title></head>");
    out.println("<body><h1>회원 목록</h1>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>전화번호</th> <th>가입일</th> </tr>");
    for (Member member : members) {
      out.println(String.format(
          "<tr> <td>%d</td><td><a href='detail?no=%1$d'>%s</a></td> " + "<td>%s</td> "
              + "<td>%s</td> " + "<td>%s</td></tr>",
          member.getNo(), member.getName(), member.getEmail(), member.getTel(),
          member.getRegisteredDate()));
    }
    out.println("</table>");
    out.println("<p><a href='list'>목록</a>");
    out.println("</body></html>");
  }

}