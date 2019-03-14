// DBMS 적용
package com.eomcs.lms.dao.mariadb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDaoImpl implements MemberDao {
	SqlSessionFactory sqlSessionFactory;

	public MemberDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Member> findAll() {

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("memberMapper.findAll");
		}
	}


	@Override
	public List<Member> findByKeyword(String keyword) {


		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("memberMapper.findByKeyword");
		}
	}

	public void insert(Member member) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.insert("memberMapper.insert", member);
			sqlSession.commit();
		}
	}

	public Member findByNo(int no) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("memberMapper.findByNo", no);
		}
	}

	public int update(Member member) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int count = sqlSession.update("memberMapper.update", member);
			sqlSession.commit();
			return count;
		}
	}

	public int delete(int no) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int count = sqlSession.delete("memberMapper.delete", no);
			sqlSession.commit();
			return count;
		}
	}
}









