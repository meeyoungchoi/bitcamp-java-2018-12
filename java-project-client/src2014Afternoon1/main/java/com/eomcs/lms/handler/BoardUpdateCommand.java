package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.eomcs.lms.agent.BoardAgent;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {
	Scanner keyboard;
	BoardAgent boardAgent;


	public BoardUpdateCommand(Scanner keyboard, BoardAgent boardAgent) {
		this.keyboard = keyboard;
		this. boardAgent = boardAgent;
		//agent = new BoardAgent("localhost",8888,"/board");
	}

  
  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
        Board board = boardAgent.get(no);
      
        // 기존 값 복제
        Board temp = board.clone();
        
        System.out.printf("내용? ");
        String input = keyboard.nextLine();
        if (input.length() > 0) 
          temp.setContents(input);
        
        BoardAgent.update(temp);
        
        System.out.println("변경했습니다.");
        
      } catch (Exception e) {
        System.out.printf("실행 오류! : %s\n", e.getMessage());
      }
  }
}
