package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardAddCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao; // 서버의 PhotoPhotoBoardDaoImpl 객체를 대행하는 프록시 객체이다.
  
  public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }
  
  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setTitle(response.requestString("제목?"));
    board.setLessonNo(response.requestInt("수업?"));
    photoBoardDao.insert(board);
    
    response.println("저장하였습니다.");
  }
}



