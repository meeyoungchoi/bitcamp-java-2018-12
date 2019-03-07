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


    
    if (photoBoardDao.delete(no) == 0) {
      response.println("해당 번호의 사진이 없습니다.");
      return;
    }
    
    photoFileDao.deleteByPhotoBoardNo(no);
    
    response.println("삭제했습니다.");
  }
}
