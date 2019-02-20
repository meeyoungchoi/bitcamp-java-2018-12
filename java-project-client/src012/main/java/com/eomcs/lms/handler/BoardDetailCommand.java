package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  List<Board> list;
  
  public BoardDetailCommand(Scanner keyboard/*, List<Board> list*/) {
    this.keyboard = keyboard;
   // this.list = list;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    /*int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }

    Board board = list.get(index);
*/
    try {
    	out.writeUTF("/board/detail");
	    out.flush();
	    if (!in.readUTF().equals("OK"))
	      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
	    
	    out.writeInt(no);
	    out.flush();
	    
	    String status = in.readUTF();
	    
	    if (!status.equals("OK")) 
	    	throw new Exception ("서버에서 게시글 가져오기 실패");
	    
	    
	    Board board = (Board) in.readObject();
	    System.out.println(board);
	    
	    System.out.printf("내용: %s\n", board.getContents());
	    System.out.printf("작성일: %s\n", board.getCreatedDate());
    } catch (Exception e) {
    	System.out.printf("게시글 상세정보 출력오류 : %s\n",e.getMessage());
    }
  
  }
  
 /* private int indexOfBoard(int no) {
    for (int i = 0; i < list.size(); i++) {
      Board b = list.get(i);
      if (b.getNo() == no)
        return i;
    }
    return -1;
  }*/
}
