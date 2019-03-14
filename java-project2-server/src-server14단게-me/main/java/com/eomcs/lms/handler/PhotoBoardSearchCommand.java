package com.eomcs.lms.handler;
import java.util.HashMap;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardSearchCommand extends AbstractCommand {

	PhotoBoardDao photoBoardDao;

	public PhotoBoardSearchCommand(PhotoBoardDao photoBoardDao) {
		this.photoBoardDao = photoBoardDao;
	}

	@Override
	public void execute(Response response) {
		HashMap<String,Object> params = new HashMap<>();
		try {
			int lessonNo = response.requestInt("사진 파일 번호?");
			params.put("lessonNo",lessonNo);
		} catch (Exception e) {

		}

		try {
			String keyword = response.requestString("검색어?");
			if (keyword.length() > 0) 
				//
				//params.put("keyword","%" + keyword+"%");
				params.put("keyword",keyword);
		} catch (Exception e) {

		}

		List<PhotoBoard> boards = photoBoardDao.findAll(null);

		response.println("[검색 결과]]");
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
