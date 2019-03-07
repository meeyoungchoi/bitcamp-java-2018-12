package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

public class PhotoBoardDeleteCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  
  public PhotoBoardDeleteCommand(PhotoBoardDao photoBoardDao,
		  PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    int no = response.requestInt("번호?");

    photoFileDao.deleteByPhotoBoardNo(no);//자식테이블을 지우는 메서드

    
    if (photoBoardDao.delete(no) == 0) {//부모테이블ㅇ르 지우는 메서드
      response.println("해당 번호의 사진이 없습니다.");
      return;
    }
    
    
    response.println("삭제했습니다.");
  }
}
