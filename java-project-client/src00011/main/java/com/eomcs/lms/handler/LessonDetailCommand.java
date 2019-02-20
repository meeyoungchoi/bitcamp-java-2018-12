package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonDetailCommand(Scanner keyboard/*, List<Lesson> list*/) {
    this.keyboard = keyboard;
    //this.list = list;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    /*int index = indexOfLesson(no);
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

    Lesson lesson = list.get(index);
*/
 
    
    try {
    	out.writeUTF("/lesson/detail");
	    out.flush();
	    if (!in.readUTF().equals("OK"))
	      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
	    
	    out.writeInt(no);
	    out.flush();
	    
	    String status = in.readUTF();
	    
	    if (!status.equals("OK")) 
	    	throw new Exception ("서버에서 수업 목록 가져오기 실패");
	    
	    
	    Lesson lesson = (Lesson) in.readObject();
	    System.out.println(lesson);
	    
	    System.out.printf("수업명: %s\n", lesson.getTitle());
	    System.out.printf("설명: %s\n", lesson.getContents());
	    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
	    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
	    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
	    
    } catch (Exception e) {
    	System.out.printf("게시글 상세정보 출력오류 : %s\n",e.getMessage());
    }
  }

  private int indexOfLesson(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNo() == no)
        return i;
    }
    return -1;
  }
}
