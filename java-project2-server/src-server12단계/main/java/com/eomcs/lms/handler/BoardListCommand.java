package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardListCommand extends AbstractCommand {

  BoardDao boardDao;
  
  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) {
    List<Board> boards = boardDao.findAll();
    
    for (Board board : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d", 
            board.getNo(), board.getContents(), 
            board.getCreatedDate(), board.getViewCount()));
      
      //싱글스레드의 문제를 직접 확인하기 위해 출력할 때 시간을 끌어보자
      //하나 출력하고 3초 휴식
      /*try {
		Thread.currentThread().sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 멀티스레드를 사용해야한다는거를 증명하기위해*/
    }
  }

}
