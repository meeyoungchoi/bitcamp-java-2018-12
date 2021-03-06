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
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.PhotoBoardService;

@WebServlet("/photoboard/list")
@SuppressWarnings("serial")
public class PhotoBoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer"))
            .getBean(PhotoBoardService.class);

    List<PhotoBoard> boards = photoBoardService.list(0, null);

    response.setContentType("text/html;charset=UTF-8");
    request.setAttribute("list", boards);

    response.setContentType("text/html;charset=UTF-8");

    RequestDispatcher rd = request.getRequestDispatcher("/photoboard/list.jsp");
    rd.include(request, response);
  }

}