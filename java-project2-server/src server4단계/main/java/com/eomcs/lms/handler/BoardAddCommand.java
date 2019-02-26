package com.eomcs.lms.handler;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand extends  AbstractCommand {


	BoardDao boardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

	public BoardAddCommand( BoardDao boardDao) {

		this.boardDao = boardDao;
	}

	@Override
	public void execute(Response response) throws Exception {
		
			Board board = new Board();
			board.setContents(response.requestString("내용?"));//클라이언트가 입력ㅎ받아서 보낸ㄱ널 읽는다.
			//requestValue안에 캡슐로 포장되어 있다.(캡슐화)

			boardDao.insert(board);
			response.println("저장하였습니다.");

		} 
	}

