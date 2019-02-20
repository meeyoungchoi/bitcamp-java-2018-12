package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.agent.BoardAgent;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  List<Board> list;
  
  public BoardAddCommand(Scanner keyboard/*, List<Board> list*/) {
    this.keyboard = keyboard;
    //this.list = list;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    try {
   
    if (BoardAgent.add(board, in, out) == 0)
    	System.out.println("서버에서 저장 실패");
    else 
    	System.out.println("서버에서 저장 실패");
    
    out.writeObject(board);
    out.flush();
    
    String status = in.readUTF();
    
    if (!status.equals("OK"))
    	throw new Exception("서버에서 저장 실패!");
      //System.out.println("게시글 저장 성공!");
    
      System.out.println("저장하였습니다.!");
    } catch (Exception e) {
    	System.out.printf("게시글 저장 오류! :%s\n",e.getMessage());//왜? 서버에서 해당 명령어를 처리하지 못했으므로
    	//서버에서 저장 실패새서 게시글 저장오류?
    }
    //list.add(board);
    
    //System.out.println("저장하였습니다.");
  }
}
