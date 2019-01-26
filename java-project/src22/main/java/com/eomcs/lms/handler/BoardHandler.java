package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;
import java.sql.Date;
import java.util.Scanner;

public class BoardHandler {
	//BoardHanlder 클래스에서 addBoard() 와 listBoard() 메서드를 관리할수 있다.
	static final int LENGTH = 10;
	public Scanner keyboard;
	Board[] boards = new Board[LENGTH];
	int boardIdx = 0;


public void listBoard() {
  for (int j = 0; j < this.boardIdx; j++) {
	 System.out.printf("%3d, %-20s, %s, %d\n", 
	     this.boards[j].no, this.boards[j].contents, 
	     this.boards[j].createdDate, this.boards[j].viewCount);
	      }
	}
	
	public void addBoard() {
		Board board = new Board();
		
		  System.out.print("번호? ");
	      board.no = Integer.parseInt(this.keyboard.nextLine());
	      
	      System.out.print("내용? ");
	      board.contents = this.keyboard.nextLine();
	      
	      board.createdDate = new Date(System.currentTimeMillis()); 
	      
	      board.viewCount = 0;
	      
	      this.boards[this.boardIdx] = board;
	      this.boardIdx++;
	      
	      System.out.println("저장하였습니다.");
	      
		
	}
}
