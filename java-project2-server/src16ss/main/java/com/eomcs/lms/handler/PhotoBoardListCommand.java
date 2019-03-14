package com.eomcs.lms.handler;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardListCommand extends AbstractCommand {

	SqlSessionFactory sqlSessionFacotory;

	public PhotoBoardListCommand(SqlSessionFactory sqlSessionFacotory) {
		this.sqlSessionFacotory = sqlSessionFacotory;
	}

	@Override
	public void execute(Response response) {

		try (SqlSession sqlSession = sqlSessionFacotory.openSession()) {

			PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);

			List<PhotoBoard> boards = photoBoardDao.findAll(null);

			for (PhotoBoard board : boards) {
				response.println(
						String.format("%3d, %-20s, %s, %d, %d", 
								board.getNo(), 
								board.getTitle(), 
								board.getCreatedDate(), 
								board.getViewCount(),
								board.getLessonNo()));
			}
		}
	}

}
