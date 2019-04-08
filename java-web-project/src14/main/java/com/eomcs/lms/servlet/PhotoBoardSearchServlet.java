package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/search")
public class PhotoBoardSearchServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PhotoBoardService photoBoardService = ((ApplicationContext) this.getServletContext()
        .getAttribute("iocContainer")).getBean(PhotoBoardService.class);
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>사진 목록 검색</title></head>");
    out.println("<body>");
    
    // 헤더를 출력한다.
    request.getRequestDispatcher("/header").include(request, response);
    
    out.println("<h1>사진 목록 검색</h1>");

    int lessonNo = 0;
    try {
      lessonNo = Integer.parseInt(request.getParameter("lessonNo"));
    } catch (Exception e) {// 수업 번호를 입력하지 않거나 정상 입력이 아닌 경우는 무시한다.
    }
    String searchWord = null;
    try {
      String keyword = request.getParameter("searchWord");
      if (keyword.length() != 0) {
        searchWord = keyword;
      }
    } catch (Exception e) { // 사용자가 검색어를 입력하지 않았으면 무시한다.
    }

    List<PhotoBoard> photoBoards = photoBoardService.list(lessonNo, searchWord);
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>사진 제목</th> <th>등록일</th> <th>조회수</th> "
        + "<th>사진 번호</th> </tr>");

    out.println("[검색 결과]");
    for (PhotoBoard photoBoard : photoBoards) {
      out.println(
          String.format(
              "<tr><td>%d</td> "
                  +"<td><a href='detail?no=%1$d'>%s</a></td> "
                  + "<td>%s</td> "
                  + "<td>%s</td> "
                  + "<td>%s</td> ", 
                  photoBoard.getNo(), photoBoard.getTitle(), 
                  photoBoard.getCreatedDate(), photoBoard.getViewCount(),
                  photoBoard.getLessonNo()));
    }
    out.println("<a href='list'>목록</a>");
    out.println("</table></body></html>");
  }
}