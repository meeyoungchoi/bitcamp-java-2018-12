// DBMS 적용s
package com.eomcs.lms.dao.mariadb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.DataSource;

public class LessonDaoImpl implements LessonDao {

	// DAO가 사용하는 커넥션 객체를 외부에서 주입 받는다.
	DataSource dataSource;

	//mybatis 의존 객체 선언
	SqlSessionFactory sqlSessionFactory;

	public LessonDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}


	public List<Lesson> findAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("LessonMapper.findAll");
		}
	}

	public void insert(Lesson lesson) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.insert("LessonMapper.insert",lesson);
			sqlSession.commit();
	} 
}
	
				

	public Lesson findByNo(int no) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("LessonMapper.findByNo", no);
		}
	}
				

			

	public int update(Lesson lesson) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int count = sqlSession.selectOne("LessonMapper.update", lesson);
			sqlSession.commit();
			return count;
		}	
	}

	public int delete(int no) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
				return sqlSession.selectOne("LessonMapper.delete",no); 
		}
	}
}







