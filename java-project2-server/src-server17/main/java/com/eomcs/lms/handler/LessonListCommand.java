package com.eomcs.lms.handler;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand extends AbstractCommand {
  
	SqlSessionFactory sqlSessionFacotory;

	public LessonListCommand(SqlSessionFactory sqlSessionFacotory) {
		this.sqlSessionFacotory = sqlSessionFacotory;
	}

  
  
  @Override
  public void execute(Response response) throws Exception {
	  
	  try (SqlSession sqlSession = sqlSessionFacotory.openSession()) {
		  
		  LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
	  
    List<Lesson> lessons = lessonDao.findAll();
    for (Lesson lesson : lessons) {
      response.println(String.format("%3d, %-15s, %10s ~ %10s, %4d", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours()));
    }
    }
  }
}
