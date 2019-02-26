package com.eomcs.lms.handler;
import java.sql.Date;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand extends AbstractCommand {

  
  LessonDao lessonDao;
  
  public LessonAddCommand(LessonDao lessonDao) {
    
    this.lessonDao = lessonDao;
  }
  

  @Override
  public void execute(Response response) throws Exception {

    Lesson lesson = new Lesson();
    lesson.setTitle(response.requestString("수업명?"));
    lesson.setContents(response.requestString("설명"));
    lesson.setStartDate(Date.valueOf(response.requestString("시작일")));
    lesson.setEndDate(Date.valueOf(response.requestString("종료일")));
    lesson.setTotalHours(Integer.parseInt(response.requestString("총수업시간")));
    lesson.setDayHours(Integer.parseInt(response.requestString("일수업시간")));

      lessonDao.insert(lesson);
      System.out.println("저장하였습니다.");
      
   
  }
  
}
