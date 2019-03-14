package com.eomcs.lms.handler;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.mybatis.TransactionManager;

public class LessonDeleteCommand extends AbstractCommand {

	SqlSessionFactory sqlSessionFacotory;
	  
	  public LessonDeleteCommand(SqlSessionFactory sqlSessionFacotory) {
	    this.sqlSessionFacotory = sqlSessionFacotory;
	  }
  

  @Override
  public void execute(Response response) throws Exception {
	  SqlSession sqlSession = sqlSessionFacotory.openSession();
	  PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);
	  PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);
	  
    try   {
    	LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      int no = response.requestInt("번호?");
      
      HashMap<String,Object> params = new HashMap<>();
      params.put("lessonNo", no);
      
      List<PhotoBoard> boards = photoBoardDao.findAll(params);
      for (PhotoBoard board : boards) {
        photoFileDao.deleteByPhotoBoardNo(board.getNo());
        photoBoardDao.delete(board.getNo());
      }
      
      if (lessonDao.delete(no) == 0) {
        response.println("해당 번호의 수업이 없습니다.");
        return;
      }
      response.println("삭제했습니다.");
      sqlSession.commit();
      
    } catch (Exception e) {
    	sqlSession.rollback();
      response.println("삭제 중 오류 발생.");
    }
  }
}




