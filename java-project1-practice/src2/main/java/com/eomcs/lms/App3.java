//06까지
package com.eomcs.lms;

import java.util.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    
    //Board 배열 객체 생성
    //객체를 다루기 위한 참조변수 boards만 만들어졌다.
    //아직 배열 객체는 생성되지 않았다.
    Board[] boards = new Board[LENGTH];
    
    

    int boardIdx = 0;

    while (true) {
      
      //Board 타입의 board 객체를 만들어줘야 한다.
      Board board = new Board();
      
      System.out.println("명령>");
      String write = keyboard.nextLine();
      
      if (write.equals("/board/add")) {
      
      System.out.print("번호: \n");
      board.number = Integer.parseInt(keyboard.nextLine());

      System.out.print("내용: \n");
      board.content = keyboard.nextLine();

      board.registeredDate = new Date(System.currentTimeMillis());
      
      board.count = 0;

      boards[boardIdx] = board;
      boardIdx++;
      
      System.out.println("저장하였습니다.");
      
      } else if (write.equals("/board/list")) {
        for (int j = 0; j < boardIdx; j++) {
          System.out.printf("%d, %s\n",
              boards[j].number, boards[j].content);
        }
      }
    }
  }
}
