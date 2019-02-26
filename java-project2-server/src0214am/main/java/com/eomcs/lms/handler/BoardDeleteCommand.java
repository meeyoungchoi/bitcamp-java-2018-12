package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.eomcs.lms.agent.BoardAgent;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  //List<Board> list;
  
  public BoardDeleteCommand(Scanner keyboard ) {
    this.keyboard = keyboard;
    //this.list = list;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
//같은 객체에서 시리얼라이즈 한걸르 내부적으로 오브젝트가 갖고있다.
    try {
      BoardAgent.delete(no, in, out);
      System.out.println("삭제했습니다.");
        
      } catch(Exception e) {
    	System.out.printf("게시글 삭제 오류!:%s\n",e.getMessage());
    }
    
   
   /* int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");*/
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
