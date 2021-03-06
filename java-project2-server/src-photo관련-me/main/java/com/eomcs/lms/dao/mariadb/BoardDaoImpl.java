package com.eomcs.lms.dao.mariadb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

	 // Mybatis 의존 객체 선언
	  SqlSessionFactory sqlSessionFactory;
	  
  public BoardDaoImpl(  SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Board> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
    	return sqlSession.selectList("BoardMapper.findAll");

    }
  }

  public void insert(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
    	 sqlSession.insert("BoardMapper.insert", board);
    	 sqlSession.commit();
    }
  }

  public Board findByNo(int no) {
    
      try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
    	  return sqlSession.selectOne("BoardMapper.findByNo", no);
      }
  }

  public int update(Board board) {
   
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
    		int count = sqlSession.update("BoardMapper.update",board);
    		sqlSession.commit();
    		return count;
    }
  }
  
  public int delete(int no) {
    
    
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
    	 int count = sqlSession.delete("BoardMapper.delete", no);
         sqlSession.commit();
         return count;

    }
  }
}









