import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;//import문을 사용하여 Board클래스의 클래스명을 명시해주면 BoardHandler클래스에서 Board클래스의 단수명인
//board를 사용하여 참조할수 있다.

/*
 * : 게시물 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라. 

- BoardHandler.java
    - `App.java` 에서 게시물관리와 관련된 변수와 메서드를 `BoardHandler` 클래스로 옮긴다.
 * 
 *12.  : 새 게시판을 추가하라.

- BoardHandler.java
    - 게시판 마다 게시글을 개별적으로 다루도록 변수를 인스턴스 멤버로 전환한다.
    - 인스턴스 변수를 다루기 위해 클래스 메서드를 인스턴스 메서드로 전환한다.
    
    14.  핸들러 객체의 필수 입력 값인 keyboard를 반드시 설정하게 만들라!
    	BoardHandler.java
    - 기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
    
 * 
 * */

public class BoardHandler {
	 
	 static final int LENGTH = 10;//클래스변수
	  
	 Scanner keyboard;
	 Board[] boards = new Board[LENGTH];//게시판 마다 게시글을 개별적으로 다루기 위해 static이였던 boards배열을 인스턴스 변수인 boards배열로 전환하였다.
	 int boardIdx = 0;//인스턴스 변수, board배열의 배열 인덱스
	 
	 public BoardHandler(Scanner keyboard) {//기본생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
		 this.keyboard = keyboard;
	 }
	 
	public void addBoard() {
		    Board board = new Board();
		    
		    System.out.print("번호? ");
		    board.no = Integer.parseInt(keyboard.nextLine());
		    
		    System.out.print("내용? ");
		    board.contents = keyboard.nextLine();
		    
		    board.createdDate = new Date(System.currentTimeMillis()); 
		    
		    board.viewCount = 0;
		    
		    boards[boardIdx] = board;
		    boardIdx++;
		    
		    System.out.println("저장하였습니다.");
		  }

	public void listBoard() {
		    for (int j = 0; j < boardIdx; j++) {
		      System.out.printf("%3d, %-20s, %s, %d\n", 
		          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
		    }
		  }
}
