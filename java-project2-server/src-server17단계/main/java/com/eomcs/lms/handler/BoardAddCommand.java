package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand extends AbstractCommand {

	SqlSessionFactory sqlSessionFacotory; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

	public BoardAddCommand(SqlSessionFactory sqlSessionFacotory) {
		this.sqlSessionFacotory = sqlSessionFacotory;
	}

	@Override
	public void execute(Response response) throws Exception {
		try (SqlSession sqlSession = sqlSessionFacotory.openSession()) {

			BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
			
			Board board = new Board();
			board.setContents(response.requestString("내용?"));
			boardDao.insert(board);
			
			sqlSession.commit();
			

			response.println("저장하였습니다.");
		}
	}
}



