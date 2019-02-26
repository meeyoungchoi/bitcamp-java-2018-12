package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {
  
  Scanner keyboard;
  List<Lesson> list;

  public LessonListCommand(Scanner keyboard/*, List<Lesson> list*/) {
    this.keyboard = keyboard;
    //this.list = list;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
	  
	  try {
			out.writeUTF("/lesson/list"); 
			out.flush();
			if (!in.readUTF().equals("OK"))
				//return;
				throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

			String status = in.readUTF();

			if (!status.equals("OK")) {
				throw new Exception("서버에서 수업 목록 가져오기 실패!");
				//System.out.println("데이터 목록 가져오기 실패!");
				//return;
				
			}
			
			@SuppressWarnings("unchecked")//ok라면
			List<Lesson> lessons = (List<Lesson>) in.readObject();
			System.out.println("");
			for (Lesson lesson : lessons) {
				 System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
				          lesson.getNo(), lesson.getTitle(), 
				          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
			}
		} catch (Exception e) {
			System.out.printf("게시글 목록 출력 오류! :%s\n",e.getMessage());
		}
	  
	  
   // Lesson[] lessons = list.toArray(new Lesson[] {});
    //for (Lesson lesson : lessons) {
     
    //}
  }
}
