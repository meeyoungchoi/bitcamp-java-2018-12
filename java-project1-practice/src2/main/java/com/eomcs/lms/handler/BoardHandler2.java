//12과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler2 {

  public static Scanner keyboard;
  static final int LENGTH = 10;
  static  Board[] boards = new Board[LENGTH];
  static  int boardIdx = 0;
  
  public static void addBoard() {
    
    Board board = new Board();

    System.out.print("번호: ");
    board.number = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용: ");
    board.content = keyboard.nextLine();

    board.registeredDate = new Date(System.currentTimeMillis());

    board.count = 0;

    boards[boardIdx] = board;
    boardIdx++;

    System.out.println("저장하였습니다.");

  } 
  
  public static void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%d, %s\n",
          boards[j].number, boards[j].content);
    }
  } 
}
