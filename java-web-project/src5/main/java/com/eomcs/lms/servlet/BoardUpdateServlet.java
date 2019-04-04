package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    BoardService boardService = InitServlet.iocContainer.getBean(BoardService.class);

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setContents(request.getParameter("contents"));
    
    if (boardService.update(board) > 0) {
      response.sendRedirect("list");
      return;
    }

    response.setHeader("Refresh", "1;url=list");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>"
        + "<title>게시물 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
 
    
   
      out.println("<p>해당 번호의 게시물이 없습니다.</p>");
      out.println("</body></html>");
    } 
    
//오루가 있으면 내용 출력후 리프래시
  //없으면 리다이렉트
  }
 











