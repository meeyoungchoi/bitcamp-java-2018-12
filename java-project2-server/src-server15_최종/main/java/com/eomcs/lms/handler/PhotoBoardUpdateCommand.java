package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.mybatis.TransactionManager;

public class PhotoBoardUpdateCommand extends AbstractCommand {

	PhotoBoardDao photoBoardDao;
	PhotoFileDao photoFileDao;
	TransactionManager txManager;

	public PhotoBoardUpdateCommand(
			PhotoBoardDao photoBoardDao,
			PhotoFileDao photoFileDao,
			TransactionManager txManager) {
		this.photoBoardDao = photoBoardDao;
		this.photoFileDao = photoFileDao;
		this.txManager = txManager;
	}

	@Override
	public void execute(Response response) throws Exception {
		txManager.beginTransaction();
		try {
			PhotoBoard board = new PhotoBoard();
			board.setNo(response.requestInt("번호?"));

			PhotoBoard origin = photoBoardDao.findByNo(board.getNo());
			if (origin == null) {
				response.println("해당 번호의 사진이 없습니다.");
				return;
			}

			String input = response.requestString(
					String.format("제목(%s)?", origin.getTitle()));

			if (input.length() > 0) {
				board.setTitle(input);
				photoBoardDao.update(board); // 사진 게시물 제목 변경
			}

			// 변경하려면 사진 게시물의 첨부 파일을 출력한다.
			response.println("사진 파일:");
			List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(board.getNo());
			for (PhotoFile file : files) {
				response.println("> " + file.getFilePath());
			}
			response.println("");

			response.println("사진은 일부만 변경할 수 없습니다.");
			response.println("전체를 새로 등록해야 합니다.");
			input = response.requestString("사진을 변경하시겠습니까?(y/N)");
			if (input.equalsIgnoreCase("y")) {
				// 먼저 기존 첨부 파일을 삭제한다.
				photoFileDao.deleteByPhotoBoardNo(board.getNo());

				// 그리고 새 첨부 파일을 추가한다.
				response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
				response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

				ArrayList<PhotoFile> photoFiles = new ArrayList<>();
				while (true) {
					String filePath = response.requestString("사진 파일?");
					if (filePath.length() == 0) {
						if (photoFiles.size() == 0) {
							response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
							continue;
						} else {
							break;
						}
					}
					PhotoFile file = new PhotoFile();
					file.setFilePath(filePath);
					file.setPhotoBoardNo(board.getNo());// 사진 게시물을 입력한 후 자동 생성된 PK 값을 꺼낸다.

					// 첨부파일을 DB에 저장
					//photoFileDao.insert(file);
					//  photoFiles++;
					//바로바로 인서트 안시킨다.
					photoFiles.add(file);
				}
				//한 번에 파일 정보를 insert 한다. 서버에 인서트는 한번만 전달된다. 사용자가 파일하나 입력하면 인서트하느게 아니라
				//인서트문을 한번만 하면된다. 매번 인서트를 하지 않아도 된다.
				photoFileDao.insert(photoFiles);
			}



			response.println("변경했습니다.");
			txManager.commit();

		} catch (Exception e) {
			txManager.rollback();
			response.println("변경 중 오류 발생.");
		}
	}
}






