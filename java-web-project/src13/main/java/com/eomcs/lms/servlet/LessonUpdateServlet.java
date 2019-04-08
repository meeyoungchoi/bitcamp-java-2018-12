package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/update")
@SuppressWarnings("serial")
public class LessonUpdateServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LessonService lessonService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer"))
            .getBean(LessonService.class);

    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(request.getParameter("no")));
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));

    if (lessonService.update(lesson) > 0) {
      response.sendRedirect("list");
      return;
    }

    response.setHeader("Refresh", "content='3;url=list'");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head>" + "<title>수업 정보 변경</title>" + "</head>");
    out.println("<body>");
    out.println("<h1>수업 정보 변경</h1>");

    out.println("<p>해당 번호의 게시물이 없습니다.</p>");
    out.println("</body></html>");

  }
}