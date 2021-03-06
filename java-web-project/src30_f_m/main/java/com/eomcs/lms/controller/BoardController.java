package com.eomcs.lms.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.context.RequestParam;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Controller
public class BoardController {
  
  @Autowired BoardService boardService;
  
  @RequestMapping("/board/form")
  public String form() throws Exception {
    return "/board/form.jsp";
  }
  
  @RequestMapping("/board/add")//add메서드를 호출하라고 표시하는 애노테이션
  public String add(
      @RequestParam("contents") String contents) throws Exception {//add라는 메서드를 호출할때 contents값을 다오
    //클라이언트가 보낸 헤더값을 받고싶을때 붙이는 애노테이션
    
    Board board = new Board();
    board.setContents(contents);
    
    boardService.add(board);
    
    return "redirect:list";
  }
  
  @RequestMapping("/board/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
  
    if (boardService.delete(no) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
    
    return "redirect:list";
  }
  
  @RequestMapping("/board/detail")
  public String detail(
      @RequestParam("no") int no,
      Map<String,Object> map) throws Exception {

    Board board = boardService.get(no);
    map.put("board", board);
    
    // 뷰 컴포넌트의 URL을 프론트 컨트롤러에게 리턴한다.
    return "/board/detail.jsp";
  }
  
  @RequestMapping("/board/list")
  public String list(Map<String,Object> map) throws Exception {
    
    List<Board> boards = boardService.list();
    map.put("list", boards);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/board/list.jsp";
  }
  
  @RequestMapping("/board/update")
  public String update(
      @RequestParam("no") int no,
      @RequestParam("contents") String contents) throws Exception {
    Board board = new Board();
    board.setNo(no);
    board.setContents(contents);
    
    if (boardService.update(board) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
      
    return "redirect:list";
  }
}










