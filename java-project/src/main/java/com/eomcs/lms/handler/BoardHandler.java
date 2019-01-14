package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;
import java.sql.Date;
import java.util.Scanner;
 public class BoardHandler {
    
 public static Scanner keyboard ;
  
 static final int LENGTH = 10;
  
 static Board[] boards = new Board[LENGTH];
 static int boardIdx = 0;
  

  public static void listBoard() {
    for (int j = 0; j <  boardIdx; j++) {
      System.out.printf("%d, %s, %s, %d", boards[j].no, boards[j].contents
          ,boards[j].createdDate, boards[j].viewCount);
      
    }
   }
  
  public static void addBoard() {
    
    Board board = new Board();
    
    System.out.printf("번호?");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.printf("내용?");
    board.contents = keyboard.nextLine();
    
    board.viewCount = 0;
    
    board.createdDate = new Date(System.currentTimeMillis());
    
    boards[boardIdx] = board;
    boardIdx++;
  }
  
  
  
}
