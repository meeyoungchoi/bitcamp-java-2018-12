package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.ArrayList;

public class BoardHandler {
  
  Scanner keyboard;
  ArrayList<Board> list;
  //Board[] board = new Board[LENGTH];
  //int boardIdx = 0;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }
  
  @SuppressWarnings("unchecked")
public void listBoard() {
	  Board[] boards = list.toArray(new Board[] {});//Board[] boards/ Object[] objs / new Board[] {}: Board{} 클래스에 있는 모든 변수를 가져온다?
	  for (Board board : boards) {//Board board : boards/ Object obj : objs
		  //Board board = (Board) obj; //이제 형변환 할 필요가 없어진다.
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
