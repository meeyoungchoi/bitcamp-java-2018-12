
package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    MemberService memberService = ServerApp.iocContainer.getBean(MemberService.class);
    response.setContentType("text/html;charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>회원 탈퇴</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>회원 탈퇴</h1>");
    out.println("</body></html>");
    if (memberService.delete(no) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");
    } else {
      out.println("<p>삭제했습니다.</p>");
    }
    out.println("</body></html>");
  }
}