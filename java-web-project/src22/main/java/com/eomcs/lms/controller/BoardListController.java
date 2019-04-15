package com.eomcs.lms.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

//페이지 컨트롤러는 Spring IOC 컨테이너에서 관리할 것이다.
//따라서 클래스에 @Controller 애노테이션을 붙여라!
@Controller("/board/list")
public class BoardListController implements PageController {

  @Autowired BoardService boardService;//생성자를 만들 필요가 없다. 

  @Override
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception {

    List<Board> boards = boardService.list();

    // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    request.setAttribute("list", boards);

    //뷰 컴포넌트의 url을 이 메서드를 호출한 프론트 컨트로러에게 리턴한다.
    return "/board/list.jsp";
  }
}










