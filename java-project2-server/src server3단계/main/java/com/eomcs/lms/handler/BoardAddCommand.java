package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {


	BoardDao boardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

	public BoardAddCommand( BoardDao boardDao) {

		this.boardDao = boardDao;
	}

	@Override
	public void execute(BufferedReader in, PrintWriter out) {
		try {
			Board board = new Board();

			out.println("내용? ");
			out.println("!{}!");
			out.flush();
			board.setContents(in.readLine());//클라이언트가 입력ㅎ받아서 보낸ㄱ널 읽는다.

			boardDao.insert(board);
			out.println("저장하였습니다.");

		} catch (Exception e) {
			out.printf("실행 오류! : %s\n", e.getMessage());
		}
	}
}
