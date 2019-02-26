package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;
import java.sql.Date;
import java.util.Scanner;



public class BoardHandler {
	//BoardHanlder 클래스에서 addBoard() 와 listBoard() 메서드를 관리할수 있다.
	public Scanner keyboard;//?
	static final int LENGTH = 10;
	Board[] boards = new Board[LENGTH];
	int boardIdx = 0;
	
	//BoardHandler()의 기본생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한것
	public BoardHandler(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	//Board 인스턴스의 값을 다룰 연산자 정의
	public void addBoard() {//Board 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.
		Board board = new Board();
		
		  System.out.print("번호? ");
	      board.setNo(Integer.parseInt(keyboard.nextLine()));
	      
	      System.out.print("내용? ");
	      board.setContents(keyboard.nextLine());
	      
	      board.setCreatedDate(new Date(System.currentTimeMillis())); 
	      
	      board.setViewCount(0);
	      
	      this.boards[this.boardIdx] = board;
	      this.boardIdx++;
	      
	      System.out.println("저장하였습니다.");
	      
		
	}

	public void listBoard() {
		
		for (int j = 0; j < this.boardIdx; j++) {
	        System.out.printf("%3d, %-20s, %s, %d\n", 
	            this.boards[j].getNo(), this.boards[j].getContents(), 
	            this.boards[j].getCreatedDate(), this.boards[j].getViewCount());
	      }
	}
}
