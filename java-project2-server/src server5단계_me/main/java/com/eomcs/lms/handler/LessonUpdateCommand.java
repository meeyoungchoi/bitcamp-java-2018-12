package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand extends AbstractCommand {


  LessonDao lessonDao;
  
  public LessonUpdateCommand(Scanner keyboard, LessonDao lessonDao) {
    
    this.lessonDao = lessonDao;
  }
  

  @Override
  public void execute(Response response) throws Exception {
	  
   Lesson lesson = new Lesson();
    lesson.setNo(response.requestInt("번호?"));

    
     
      if (lesson == null) {
        System.out.println("해당 번호의 수업이 없습니다.");
        return;
      }
      
      Lesson temp = lesson.clone();
      
      response.println(String.format("수업명(%s)? ", lesson.getTitle()) );
   
      
      
      out.printf("설명(%s)? ", lesson.getContents());
      if ((input = in.readLine()).length() > 0)
        temp.setContents(input);
      
      out.printf("시작일(%s)? ", lesson.getStartDate());
      if ((input = in.readLine()).length() > 0)
        temp.setStartDate(Date.valueOf(input));
      
      out.printf("종료일(%s)? ", lesson.getEndDate());
      if ((input = in.readLine()).length() > 0)
        temp.setEndDate(Date.valueOf(input));
      
      out.printf("총수업시간(%d)? ", lesson.getTotalHours());
      if ((input = in.readLine()).length() > 0)
        temp.setTotalHours(Integer.parseInt(input));
      
      out.printf("일수업시간(%d)? ", lesson.getDayHours());
      if ((input = in.readLine()).length() > 0)
        temp.setDayHours(Integer.parseInt(input));
      
      lessonDao.update(temp);
       
      System.out.println("변경했습니다.");
      
    
  }
}
