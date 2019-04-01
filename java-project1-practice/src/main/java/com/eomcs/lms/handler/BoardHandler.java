//13,14,15,16,17,18과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.ArrayList;

public class BoardHandler {

  Scanner keyboard;

  ArrayList<Board> list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new ArrayList<>(20);
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
    Object[] objects = list.toArray();
    for (Object object : objects) {
      Board board = (Board) object;
      System.out.printf("%d, %s\n",
          board.getNumber(), board.getContent());
    }
  } 
}
