package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@SuppressWarnings("serial")
@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
    LessonService lessonService = ((ApplicationContext) this.getServletContext()
        .getAttribute("iocContainer")).getBean(LessonService.class);
    response.setContentType("text/html;charset=UTF-8");
    List<Lesson> lessons = lessonService.list();

    request.setAttribute("lessons", lessons);
    request.getRequestDispatcher("/lesson/list.jsp").include(request, response);
  }
}