package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardUpdateCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  
  public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao,
		  PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }
  
  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setNo(response.requestInt("번호?"));
    board.setTitle(response.requestString("제목?"));
    
    
    if (photoBoardDao.update(board) == 0) {
      response.println("해당 번호의 게시물이 없습니다.");
      return;
    }
    board.setTitle(response.requestString(String.format("제목?")));
    
    
    
    //변경하려면 사진 게시물의 첨부 파일을 출력한다.
    response.println("사진 파일:");
    List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(board.getNo());
    for (PhotoFile file : files) {
    	response.println(">" + file.getFilePath());
    }
    
    response.println("사진은 일부만 변경할 수 없습니다.");
    response.println("전체를 새로 등록해야 합니다.");
    String input = response.requestString("사진을 변경하시셌습니까?(y/N)");
    if (input.equalsIgnoreCase("y")) {
    	//먼저 기존 파일을 삭제한다.
    	//response.println("사진 파일 변경했습니다.");

    	photoFileDao.deleteByPhotoBoardNo(board.getNo());
    	
    	//그리고 새 첨부파일을 추가한다.
        response.println("최소 한개의 사진 파일을 등록해야 합니다.");
        response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");
        
        List<String> file = new ArrayList<>();
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
    }
    
    response.println("변경했습니다.");
  }
}