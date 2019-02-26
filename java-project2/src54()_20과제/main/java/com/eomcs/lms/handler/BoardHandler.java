package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;//import문을 사용하여 Board클래스의 클래스명을 명시해주면 BoardHandler클래스에서 Board클래스의 단수명인
//board를 사용하여 참조할수 있다.

public class BoardHandler {
	 
	 static final int DEFAULT_CAPACITY = 10;//클래스변수
	  
	 Scanner keyboard;
	 LinkedList<Board> list; //게시판 마다 게시글을 개별적으로 다루기 위해 static이였던 boards배열을 인스턴스 변수인 boards배열로 전환하였다.
	 
	 
	 public BoardHandler(Scanner keyboard) {//기본생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
		 this.keyboard = keyboard;
		 this.list = new LinkedList<>();
	 }
	 
	public void addBoard() {
		    Board board = new Board();
		    
		    System.out.print("번호? ");
		    board.setNo(Integer.parseInt(keyboard.nextLine()));
		    
		    
		    System.out.print("내용? ");
		    board.setContents(keyboard.nextLine()); 
		    
		    board.setCreatedDate(new Date(System.currentTimeMillis())); 
		    
		    board.setViewCount(0); 
		    
		    list.add(board);
		    
		    System.out.println("저장하였습니다.");
		  }

	public void listBoard() {
		//Object[] objs = list.toArray();
		Board[] boards = list.toArray(new Board[] {});
				for ( /*Object obj : objs*/ Board board : boards) {
		    	//Board board = (Board) obj;//board 레펀런스가 가리키는 실제 Board타입을 그대로 사용하고 싶다면,
		    	//즉 obj에 저장된 Board클래스를 그대로 사용하고 싶다면 => 형변환 해서 사용해라
		    	//컴파일러야 obj에 들어있는 주소가 원래 Board의 인스턴스야 
		    	//그러니 board에 obj를 저장하렴
		      System.out.printf("%3d, %-20s, %s, %d\n", 
		          board.getNo(), board.getContents(), board.getCreatedDate(), board.getViewCount());
		 }
	}

	public void detailBoard() {
		 System.out.print("번호? ");
		    int no = Integer.parseInt(keyboard.nextLine());

		    int index = indexOfBoard(no);
		    if (index == -1) {
		      System.out.println("해당 게시글을 찾을 수 없습니다.");
		      return;
		    }

		    Board board = list.get(index);

		    System.out.printf("내용: %s\n", board.getContents());
		    System.out.printf("작성일: %s\n", board.getCreatedDate());
	}

	private int indexOfBoard(int no) {
		for (int i = 0; i < list.size(); i++) {
		      Board b = list.get(i);
		      if (b.getNo() == no)
		        return i;
		    }
		    return -1;
		  }
	

	public void updateBoard() {
		 System.out.print("번호? ");
		    int no = Integer.parseInt(keyboard.nextLine());

		    int index = indexOfBoard(no);
		    if (index == -1) {
		      System.out.println("해당 게시글을 찾을 수 없습니다.");
		      return;
		    }
		    
		    Board board = list.get(index);
		    
		    try {
		      // 기존 값 복제
		      Board temp = board.clone();
		      
		      System.out.printf("내용? ");
		      String input = keyboard.nextLine();
		      if (input.length() > 0) 
		        temp.setContents(input);
		      
		      list.set(index, temp);
		      
		      System.out.println("게시글을 변경했습니다.");
		      
		    } catch (Exception e) {
		      System.out.println("변경 중 오류 발생!");
		    }
		
}

	public void deleteBoard() {
	    System.out.print("번호? ");
	    int no = Integer.parseInt(keyboard.nextLine());

	    int index = indexOfBoard(no);
	    if (index == -1) {
	      System.out.println("해당 게시글을 찾을 수 없습니다.");
	      return;
	    }
	    
	    list.remove(index);
	    
	    System.out.println("게시글을 삭제했습니다.");
		
	}
}
