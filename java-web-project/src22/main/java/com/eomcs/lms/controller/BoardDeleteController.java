package com.eomcs.lms.controller;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@Controller("/board/delete")
public class BoardDeleteController implements PageController {
  

  @Autowired BoardService boardService;
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    if (boardService.delete(no) > 0) {
     //뷰 컴포넌트의 url을 ServletRequest보관소에 저장한다.
      request.setAttribute("viewUrl", "redirect:list");
    }
    
    return "redirect:list";
    }
    
  }













