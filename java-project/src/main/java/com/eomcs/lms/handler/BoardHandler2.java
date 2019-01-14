package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;
import java.sql.Date;
import java.util.Scanner;
public class BoardHandler2 {
  
  public static Scanner keyboard ;
  
  static  final int LENGTH = 10;
  
  static  Board[] boards = new Board[LENGTH];
  static int boardIdx = 0;
  
  public  void listBoard() {
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%d, %s", boards[j].no, boards[j].contents);
      
    }
   }
  
 public  void addBoard() {
    
    Board board = new Board();
    
    System.out.printf("번호?");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.printf("내용?");
    board.contents = keyboard.nextLine();
    
    board.viewCount = 0;
    
    board.createdDate = new Date(System.currentTimeMillis());
    
    this.boards[boardIdx] = board;
    this.boardIdx++;
  }

}
