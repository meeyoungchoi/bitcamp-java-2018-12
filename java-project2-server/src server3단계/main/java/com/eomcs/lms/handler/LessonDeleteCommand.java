package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDeleteCommand implements Command {

  
  LessonDao lessonDao;
  
  public LessonDeleteCommand(LessonDao lessonDao) {
    
    this.lessonDao = lessonDao;
  }
  

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
	  try {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.readLine());

    
    Lesson lesson = lessonDao.findByNo(no);
      if (lessonDao.delete(no) == 0) {
        System.out.println("해당 번호의 수업이 없습니다.");
        return;
      }
      out.println("삭제했습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
