package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonUpdateCommand(Scanner keyboard/*, List<Lesson> list*/) {
    this.keyboard = keyboard;
   // this.list = list;
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
    
    Lesson lesson = list.get(index);*/
    
    try {
    	out.writeUTF("/lesson/detail");
		out.flush();
		if (!in.readUTF().equals("OK"))
			throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

		out.writeInt(no);
		out.flush();

		String status = in.readUTF();

		if (!status.equals("OK")) 
			throw new Exception ("서버에서 게시글 가져오기 실패");


		Lesson lesson = (Lesson) in.readObject();
    	
      // 일단 기존 값을 복제한다.
      Lesson temp = lesson.clone();
      
      System.out.printf("수업명(%s)? ", lesson.getTitle());
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setTitle(input);
      
      System.out.printf("설명(%s)? ", lesson.getContents());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setContents(input);
      
      System.out.printf("시작일(%s)? ", lesson.getStartDate());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setStartDate(Date.valueOf(input));
      
      System.out.printf("종료일(%s)? ", lesson.getEndDate());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setEndDate(Date.valueOf(input));
      
      System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setTotalHours(Integer.parseInt(input));
      
      System.out.printf("일수업시간(%d)? ", lesson.getDayHours());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setDayHours(Integer.parseInt(input));
      
      out.writeUTF("/lesson/update");
	    out.flush();
	    if (!in.readUTF().equals("OK"))
	      //return;
	    	throw new Exception ("서버에서 수업 가져오기 실패");
	    
	    out.writeObject(temp);
	    out.flush();
	    
	    status = in.readUTF();
		if (!status.equals("OK")) 
			throw new Exception ("서버에서 게시글 가져오기 실패");
		
      
      //list.set(index, temp);
      
      System.out.println("수업을 변경했습니다.");
      
    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
  
 /* private int indexOfLesson(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNo() == no)
        return i;
    }
    return -1;
  }*/
}