//13,14,15과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  Scanner keyboard;

  final int LENGTH = 10;
  
  Board[] boards = new Board[LENGTH];
  int boardIdx = 0;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public  void addBoard() {
    
    Board board = new Board();

    System.out.print("번호: ");
    board.setNumber(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용: ");
    board.setContent(keyboard.nextLine());

    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    board.setCount(0);

    boards[boardIdx] = board;
    boardIdx++;

    System.out.println("저장하였습니다.");

  } 
  
  public void listBoard() {
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%d, %s\n",
          this.boards[j].getNumber(), this.boards[j].getContent());
    }
  } 
}
