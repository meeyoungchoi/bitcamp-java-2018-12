package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LessonService lessonService = ServerApp.iocContainer.getBean(LessonService.class);
    response.setContentType("text/html;charset=UTF-8");
    
    int no = Integer.parseInt(request.getParameter("no"));

    Lesson lesson = lessonService.get(no);
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>수업 조회</title></head>");
    out.println("<body><h1>수업 조회</h1>");
    if (lesson == null) {
      out.println("<p>해당 수업 정보가 존재하지 않습니다.</p>");
      return;
    }
    out.println("<form action='update' method='post'>");
    out.println("<table border='1'>");
    out.println(
        String.format("<tr><th>번호</th>"
            + "<td><input type='text' name='no' value='%d' readonly></td>"
            + "</tr>\n", no));
    out.println(String.format("<tr> <th>수업명</th> "
        + "<td><input type='text' name='title' value='%s'></td>"
        + "</tr>", lesson.getTitle()));
    out.println(String.format("<tr> <th>설명</th> "
        + "<td><input type='text' name='contents' value='%s'></td>"
        + "</tr>", lesson.getContents()));
    out.println(String.format("<tr> <th>시작일</th> "
        + "<td><input type='date' name='startDate' value='%s'></td>"
        + "</tr>", lesson.getStartDate()));
    out.println(String.format("<tr> <th>종료일</th> "
        + "<td><input type='date' name='endDate' value='%s'></td>"
        + "</tr>", lesson.getEndDate()));
    out.println(String.format("<tr> <th>총수업시간</th> "
        + "<td><input type='number' name='totalHours' value='%s'></td>"
        + "</tr>", lesson.getTotalHours()));
    out.println(String.format("<tr> <th>일수업시간</th> "
        + "<td><input type='number' name='dayHours' value='%s'></td>"
        + "</tr>", lesson.getDayHours()));

    out.println("</table>");
    out.println("<p><a href='list'>목록</a>"
        + " <a href='delete?no=" + lesson.getNo() + "'>삭제</a>"
        + " <button type='submit'>변경</button>"
        + "</p>"); // p = 한 문단
    out.println("</form>");
    out.println("</body></html>");
  }
}