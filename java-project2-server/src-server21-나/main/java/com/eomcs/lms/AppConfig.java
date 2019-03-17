package com.eomcs.lms;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.lms.context.Bean;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactory;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

public class AppConfig {
	
	//매서드 이름으로 객체가 저장된다.
	  @Bean
	public BoardDao boardDao(DaoFactory daoFacotry){
		return daoFacotry.create(BoardDao.class);
	}
	
	//
	  @Bean
	public MemberDao memberDao(DaoFactory daoFacotry){
		return daoFacotry.create(MemberDao.class);
	}
	
	//
	  @Bean
	public LessonDao lessonDao(DaoFactory daoFacotry){
		return daoFacotry.create(LessonDao.class);
	}
	
	//
	  @Bean
	public PhotoBoardDao photoBoardDao(DaoFactory daoFacotry){
		return daoFacotry.create(PhotoBoardDao.class);
	}
	
	//
	  @Bean
	public PhotoFileDao photoFileDao(DaoFactory daoFacotry){
		return daoFacotry.create(PhotoFileDao.class);
	}
	
	//SqlSessionFactory 객체를 만들어 주는 팩터뢰 역할을 수행하는 메서드
	@Bean//=>메서드이름으로 저장한다, // @Bean(value(또는 name)="okok")라면 okok이름으로 저장한다.
	public SqlSessionFactoryProxy sqlSessionFactoryProxy() throws IOException {
		return new SqlSessionFactoryProxy(
				new SqlSessionFactoryBuilder().build(
						Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml")));
			
				}
	
	//트랜잭션매니저 객체를 만들어 주는 메서드
	@Bean//빈을 정의한 이유: 아이오시 컨테이너에서 빈을생성하기위해서 정의한 메서드
	public TransactionManager transactionManager(
			SqlSessionFactoryProxy sqlSessionFactoryProxy) {
		 return new TransactionManager(sqlSessionFactoryProxy);
		
	}
	
	//daoFactory객체를 만들어 주는 메서드
	  @Bean
	public DaoFactory daoFactory(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
		return new DaoFactory(sqlSessionFactoryProxy);
	}

}
