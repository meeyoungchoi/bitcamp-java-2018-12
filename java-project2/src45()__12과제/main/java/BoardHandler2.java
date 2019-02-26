import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;

/*
 *  새 게시판을 추가하라.

- BoardHandler2.java
    - `/board2/add`, `/board2/list` 명령을 처리할 클래스를 추가한다
 * 
 * 
 * */
public class BoardHandler2 {
	static Scanner keyboard = new Scanner(System.in);//클래스 변수
	 static final int LENGTH = 10;//클래스변수
	 
	 static Board[] boards = new Board[LENGTH];//Static이 붙은 Board타입의 board배열
	 static int boardIdx = 0;//클래스 변수
	 
	 
	 static void addBoard() {
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
	 
	 static void listBoard() {
		    for (int j = 0; j < boardIdx; j++) {
		      System.out.printf("%3d, %-20s, %s, %d\n", 
		          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
		    }
		  }
}
