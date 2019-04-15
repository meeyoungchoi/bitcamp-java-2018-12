package com.eomcs.lms.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Controller("/board/detail")
public class BoardDetailController implements PageController {

  @Autowired BoardService boardService;
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    Board board = boardService.get(no);
    
    // JSP가 사용할 수 있도록 ServletRequest 보관소에 저장해둔다.
    request.setAttribute("board", board);
    
    return "/board/detail.jsp";
  }

}










