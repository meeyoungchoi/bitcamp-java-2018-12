package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao; // 서버의 PhotoPhotoBoardDaoImpl 객체를 대행하는 프록시 객체이다.
  PhotoFileDao photoFileDao;
  
  public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao, 
		  PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }
  
  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setTitle(response.requestString("사진 제목?"));
    board.setLessonNo(response.requestInt("수업?"));
    photoBoardDao.insert(board);
    
    response.println("최소 한개의 사진 파일을 등록해야 합니다.");
    response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");
    
    List<String> files = new ArrayList<>();
    int count = 0;
    while (true) {
    	String filePath = response.requestString("사진파일?");
    	if (filePath.length() == 0) {
    		if (files.size() == 0)  {
    			response.println("최소 한개의 사진 파일을 등록해야 합니다.");
    			continue;
    		} else {
    			break;
    		}		
    	}
    	PhotoFile file = new PhotoFile();
    	file.setFilePath(filePath);
    	file.setPhotoBoardNo(board.getNo());
    	//files.add(file);
    		
    	//files.add(filePath);
    	
    	//
    	photoFileDao.insert(file);
    	count++;
    }
    
    //첨부파일을 db에 저장한다.
   /* for (String filePath : files) {
    	PhotoFile photoFile = new PhotoFile();
    	photoFile.setFilePath(filePath);
    	//사진 게시물을 입력한 후 자동 생성된  pk 값을 꺼낸다.
    	photoFile.setPhotoBoardNo(board.getNo());//
    	photoFileDao.insert(photoFile);
    }*/
   // for (PhotoFile file : files) {
    	//photoFileDao.insert(file);
    	//count++;
    //}
    
    response.println("저장하였습니다.");
  }
}



