package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Lesson;

public class LessonDeleteCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonDeleteCommand(Scanner keyboard/*, List<Lesson> list*/) {
    this.keyboard = keyboard;
    //this.list = list;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
        out.writeUTF("/board/delete");
        out.flush();
        if (!in.readUTF().equals("OK"))
          throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
        
        out.writeInt(no);
        out.flush();
        
        String status = in.readUTF();
        
        if (!status.equals("OK")) 
          throw new Exception("서버에서 게시글을 삭제하는데 실패!");
        
        System.out.println("게시글을 삭제했습니다.");
        
      } catch(Exception e) {
    		System.out.printf("게시글 삭제 오류!:%s\n",e.getMessage());
    }
    
  //같은 객체에서 시리얼라이즈 한걸르 내부적으로 오브젝트가 갖고있다.
   
   /* int index = indexOfLesson(no);
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);*/
    
  }
  
//  
//  private int indexOfLesson(int no) {
//    for (int i = 0; i < list.size(); i++) {
//      Lesson l = list.get(i);
//      if (l.getNo() == no)
//        return i;
//    }
//    return -1;
//  }
//}
}
