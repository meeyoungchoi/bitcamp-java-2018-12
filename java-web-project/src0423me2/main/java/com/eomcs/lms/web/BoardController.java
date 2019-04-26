package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
  
  @Autowired BoardService boardService;
  
  @GetMapping("form")
  public void form() throws Exception {
    
 }
  
  @GetMapping("form")
  public String add(
      Board board) throws Exception {
    
    boardService.add(board);
    return "redirect:list";
  }
  
  @GetMapping("delete")
  public String delete(@RequestParam("no") int no) throws Exception {
  
    if (boardService.delete(no) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
    
    return "redirect:list";
  }
  
  @GetMapping("detail")
  public void detail(
     int no, Model model) throws Exception {

    //디버깅하면서 체크하기위해 변수값이 null인지 아닌지를 검사하기위해  임시변수를 만들었다.
    //장점: 코드를 이해하기 쉽다.
    //단점: 디버깅 할 떄 불편하다.
    Board board = boardService.get(no);
    model.addAttribute("board", board);
    
   // model.addAllAttributes(board, boardService.get(no));
    
    // 뷰 컴포넌트의 URL을 프론트 컨트롤러에게 리턴한다.
  //void 이면 리케스트 핸들러의 url을 jsp url로 사용한다.
  }
  
  @RequestMapping("list")
  public void list(Map<String,Object> map) throws Exception {
    
    List<Board> boards = boardService.list();
    map.put("list", boards);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    
  }
  
  @PostMapping("update")
  public String update(Board board) throws Exception {
    if (boardService.update(board) == 0) 
      throw new Exception("해당 번호의 게시물이 없습니다.");
    return "redirect:list";
  }
}










