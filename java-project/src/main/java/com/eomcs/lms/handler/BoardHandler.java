package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  Scanner keyboard;
  static final int LENGTH = 10;
  static Board[] boards = new Board[LENGTH];//처음부터 인스턴스 필드로 만드는것이 기본이다.(클래스 문버이란 메서드를 묶는것이다 라는것이 전달이 안된다.)
  static int boardIdx = 0;//하지만 클래스의 용도에 집중하기 위해서 클래스 필드로 만들었다.

  //Scanner keyboard를 받는 생성자를 만든다.
  public BoardHandler(Scanner keyboard) {//생성자는 클래스 이름과 같게 만들어야하고 리턴 타입이 없어야 한다
    this.keyboard = keyboard;//외부에서 주입한 키보드를 넣어준다
  }
  public void listBoard() {//인스턴스 메서드에는 디스가 내장되어있다.
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].no, this.boards[j].contents, this.boards[j].createdDate, this.boards[j].viewCount);
    }
  }

  public void addBoard() {//인스턴스 메서드
    Board board = new Board();
    
    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("내용? ");
    board.contents = keyboard.nextLine();
    
    board.createdDate = new Date(System.currentTimeMillis()); 
    
    board.viewCount = 0;
    
    this.boards[this.boardIdx] = board;
    this.boardIdx++;
    
    System.out.println("저장하였습니다.");
  }

}
