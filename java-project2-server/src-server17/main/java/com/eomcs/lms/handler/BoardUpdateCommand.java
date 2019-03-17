package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand extends AbstractCommand {
  
	SqlSessionFactory sqlSessionFacotory;
  
  public BoardUpdateCommand(SqlSessionFactory sqlSessionFacotory) {
    this.sqlSessionFacotory = sqlSessionFacotory;
  }
  
  @Override
  public void execute(Response response) throws Exception {
	  
	  try (SqlSession sqlSession = sqlSessionFacotory.openSession()) {
	  
		  BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		  
    Board temp = new Board();
    temp.setNo(response.requestInt("번호?"));
    
    String input = response.requestString("내용?");
    if (input.length() > 0)
      temp.setContents(input);
    
    if (temp.getContents() != null) {
      if (boardDao.update(temp) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      sqlSession.commit();
      response.println("변경했습니다.");
      
    } else {
      response.println("변경 취소했습니다.");
    }
    }
  }
}
