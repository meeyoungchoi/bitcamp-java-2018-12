package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand extends AbstractCommand {

  LessonDao lessonDao;
  
  public LessonDetailCommand( LessonDao lessonDao) {
   
    this.lessonDao = lessonDao;
  }
  

  @Override
  public void execute(Response response) throws Exception {
	  
  
    int no = response.requestInt("번호?");

    
    
      Lesson lesson = lessonDao.findByNo(no);
      if (lesson == null) {
        System.out.println("해당 번호의 수업이 없습니다.");
        return;
      }
      
      response.println(String.format("수업명: %s\n", lesson.getTitle()));
      response.println(String.format("설명: %s\n", lesson.getContents()));
      response.println(String.format("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate()));
      response.println(String.format("총수업시간: %d\n", lesson.getTotalHours()));
      response.println(String.format("일수업시간: %d\n", lesson.getDayHours()));
      
   

  }
}
