package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService{
	
	LessonDao lessonDao;
	PhotoFileDao photoFileDao;
	PhotoBoardDao photoBoardDao;

	public LessonServiceImpl(
			LessonDao lessonDao,
			PhotoFileDao photoFileDao,
			PhotoBoardDao photoBoardDao) {
		this.lessonDao = lessonDao;
		
		this.photoFileDao = photoFileDao;
		this.photoBoardDao = photoBoardDao;
	}

	@Override
	public List<Lesson> list() {
		// TODO Auto-generated method stub
		return lessonDao.findAll();
	}

	@Override
	public int add(Lesson lesson) {

		return lessonDao.insert(lesson);
	}

	@Override
	public Lesson get(int no) {
		Lesson lesson = lessonDao.findByNo(no);
		return lesson;
	}

	@Override
	public int update(Lesson lesson) {

		return lessonDao.update(lesson);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)// 이 작업은 트랜잭션 안에서 실행해야 한다. 이렇게 하면 transaction 코드를 없애도 된다. 이 메서드 호출이 끝난다음에 커밋해라
	public int delete(int no) {


		HashMap<String, Object> params = new HashMap<>();
		params.put("lessonNo", no);

		List<PhotoBoard> boards = photoBoardDao.findAll(params);
		for (PhotoBoard board : boards) {
			photoFileDao.deleteByPhotoBoardNo(board.getNo());
			photoBoardDao.delete(board.getNo());
		}
		lessonDao.delete(no);

		return 1;

	}
	//dobefore 메서드에 트랜잭션을 만드는게 들어간다.
	//doafter에ㅓ 커밋하는게 들어간다.
	//예외가 발생하면 after throwing에 들어간다,
	//이서비스 전체를 프록시로 만들게 된다.
}
