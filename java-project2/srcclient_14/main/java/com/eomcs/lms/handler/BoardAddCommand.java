package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;
import com.eomcs.lms.proxy.BoardDao;

public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;//서버에 BoardDaoImpl을 대행하는 프록시 객체
  
  public BoardAddCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  @Override
  public void execute() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    try {
      boardDao.insert(board);
      System.out.println("저장하였습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
