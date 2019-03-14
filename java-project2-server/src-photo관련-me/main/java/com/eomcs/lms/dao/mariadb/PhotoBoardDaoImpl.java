package com.eomcs.lms.dao.mariadb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

	// Mybatis 의존 객체 선언
	SqlSessionFactory sqlSessionFactory;

	public PhotoBoardDaoImpl(  SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<PhotoBoard> findAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("photoBoardMapper.findAll");

		}
	}


	@Override
	public void insert(PhotoBoard photoBoard) {


		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.selectList("photoBoardMapper.insert",photoBoard);
			sqlSession.commit();
		}
	}

	@Override
	public PhotoBoard findByNo(int no) {

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("photoBoardMapper.findByNo");
		}
	}

	@Override
	public int update(PhotoBoard photoBoard) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int count = sqlSession.update("photoBoardMapper.update",photoBoard);
			sqlSession.commit();
			return count;
		}
	}


	@Override
	public int delete(int no) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int count = sqlSession.delete("photoBoardMapper.delete", no);
			sqlSession.commit();
			return count;

		}
	}
}
