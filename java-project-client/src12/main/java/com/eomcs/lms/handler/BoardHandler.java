package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;
import java.sql.Date;
import java.util.Scanner;
 public class BoardHandler {
    
 static final int LENGTH = 10;
 //뒤에 3개가 인스턴스 필드
 public Scanner keyboard ;
 Board[] boards = new Board[LENGTH];
 int boardIdx = 0;
  
 public BoardHandler(Scanner keyboard) {
   this.keyboard = keyboard;
 }
  public void listBoard() {
    for (int j = 0; j <  boardIdx; j++) {
      System.out.printf("%d, %s, %s, %d\n", this.boards[j].getNo(), this.boards[j].contents
          ,this.boards[j].createdDate, this.boards[j].viewCount);
      
    }
   }
  
  public void addBoard() {
    
    Board board = new Board();
    
    System.out.printf("번호?");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.printf("내용?");
    board.contents = keyboard.nextLine();
    
    board.viewCount = 0;
    
    board.createdDate = new Date(System.currentTimeMillis());
    
    //boards[boardIdx]:배열이다.
    this.boards[boardIdx] = board;
    this.boardIdx++;
  }
  
  
  
}
