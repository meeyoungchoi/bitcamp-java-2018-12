//13,14,15,16과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  Scanner keyboard;

  BoardList list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new BoardList();
  }
  
  public  void addBoard() {
    
    Board board = new Board();

    System.out.print("번호: ");
    board.setNumber(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용: ");
    board.setContent(keyboard.nextLine());

    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    board.setCount(0);

   list.add(board);

    System.out.println("저장하였습니다.");

  } 
  
  public void listBoard() {
    Board[] boards = list.toArray();
    for (Board board : boards) {
      System.out.printf("%d, %s\n",
          board.getNumber(), board.getContent());
    }
  } 
}
