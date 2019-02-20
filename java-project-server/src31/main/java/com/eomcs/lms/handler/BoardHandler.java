package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  static final int LENGTH = 10;
  
  Scanner keyboard;
  ArrayList list;
  //Board[] board = new Board[LENGTH];
  //int boardIdx = 0;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList(20);
  }
  
  public void listBoard() {
	  Object[] objs = list.toArray();//Board[] boards
	  for (Object obj : objs) {//Board board : boards
		  Board board = (Board) obj;
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
      /*
       * for (int j = 0; j < lessonIdx; j++) {
       * System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n",board.getNo(),...);
       * }
       * 
       * */
    }
  }

  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    //this.boards[this.boardIdx] = board;
    //this.boardIdx++;
    list.add(board);
    
    System.out.println("저장하였습니다.");
  }

}
