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
			//openSEssion()을 하면 주머니에 저장이 안된다.

			BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
			
			Board board = new Board();
			board.setContents(response.requestString("내용?"));
			boardDao.insert(board);
			
			sqlSession.commit();
			//sqlSession은 주머니에 보관되지 않는다.
			//sqlSession은 끝나면 버려진다.
			///board/list를 수행한다해도 /board/add에서 사용된 sqlSession을 다시 재사용하지 않는다.

			response.println("저장하였습니다.");
		}
	}
}



