package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler2 {
  
  public static Scanner keyboard;
  static final int LENGTH = 10;
  static Board[] boards = new Board[LENGTH];
  static int boardIdx = 0;

  public static void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].getNo(), boards[j].getContents(), boards[j].getCreatedDate(), boards[j].getViewCount());
    }
  }

  public static void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine())); 
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(Date.valueOf(keyboard.nextLine()));     
    board.setViewCount(0);
    
    boards[boardIdx] = board;
    boardIdx++;
    
    System.out.println("저장하였습니다.");
    
    
  }

  public static Scanner getKeyboard() {
    return keyboard;
  }

  public static void setKeyboard(Scanner keyboard) {
    BoardHandler2.keyboard = keyboard;
  }

  public static Board[] getBoards() {
    return boards;
  }

  public static void setBoards(Board[] boards) {
    BoardHandler2.boards = boards;
  }

  public static int getBoardIdx() {
    return boardIdx;
  }

  public static void setBoardIdx(int boardIdx) {
    BoardHandler2.boardIdx = boardIdx;
  }

  public static int getLength() {
    return LENGTH;
  }

}
