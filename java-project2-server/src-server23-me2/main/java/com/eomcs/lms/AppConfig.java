package com.eomcs.lms;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//
@ComponentScan(basePackages="com.eomcs.lms")
//
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")

//Spring의 트랜잭션 관리자를 호라성화시킬 때 사용한다.
@EnableTransactionManagement

//3번쨰 방밥
//mybatis에서 dao 구현체를 자동 생서아헤 할 때 사용하낟.
//dao인터페이스가 있는
@MapperScan("com.eomcs.lms.dao") 
public class AppConfig {
	
	//@Autowired
	//=>빈 컨테이너에서 지정한 타입의 값을 꺼내 필드에 넣으라는 명령이다.
	//=>예) 다음은 빈 컨테이너에서 Environment 타입의 객체를 찾아 env라는 필드에 주소를 주입하라는 뜻
	//.properties 파일의 내용을 로딩한 후 그 값을 꺼낼 때 사용할 객체를 지정한다,
	@Autowired 
	Environment env;
	//Environment 객체?
	//=>@PropertySource 애노테이션에서 지정한 .properties 파일의 값을 꺼내는 일을 한다.
	
	//@Bean
	//=>객체를 생성해주는 메서드(팩터리 메서드)를 표시할 때 사용한다.
	//=>Spring Ioc 컨테이너는 이 애노테이션이 붙은 메서드를 호출하여 그 리턴 값을 보고나한다.
	//=>객체를 보관할 때 사용할 이름은 Bean 애노테이션에 지정한 이름이다,
	//만약 
	//
	
	//db 커넥션풀 기능을 수행할 DataSource 객체를 생성하는 메서드
	@Bean
	public DataSource dataSource() {
		//DBMS 정보는 JDBC.PROPERTIES 파일에 있다.
		//SPRINTG
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	
	//connection의 commit/rollback을 처리하는 트랜잭션 관리자를 생성하는 메서드
	//=>트랜잭션 매니저의 이름은 "transactionManager" 이어야 한다.
	//만약 다른 이름을 사용한다면 트랜잭션 매니저를 다룰 떄 마다
	//정확하게 그 이름을 지정해야 하는 번거로움이 발생한다.
	//=>Spring은 트랜잭션 관리자로서 PlatformTransactionManager 구현체를 사용한다.
	//=>트랜잭션 관리자는 connection을 다루는 일을 하고,
	//connection은 dataSource로 부터 얻는다.
	//따라서 트랜잭션 관리자를 만들려면 DataSource 객체가 있어야 한다.
	//=>메서드의 파라미터로 DataSource 객체를 요구하라
	//그러면 Sprint IoC 컨테이너가 메서드를 호출할 때 
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {//dataSouece를 리턴하느 메서드를 먼저 실행하낟.
		return new DataSourceTransactionManager(dataSource);
	}
	//sqlSessionFactory를 생성하는 메서드
	@Bean
	public SqlSessionFactory sqlSessionFactory(
			DataSource dataSource,
			ApplicationContext appCtx) throws Exception {
		//마이바티스에서 SqlSessionFacotry를 생성할 때 사용하라고 제공해 주는 객체이다.
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		//SqlSessionFactory 객체를 생성하는데 필요한 객체를 주입한다.
		factoryBean.setDataSource(dataSource);
		
		//도메인 클래스의 별명을 자동화
		factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
		
		//sql
		factoryBean.setMapperLocations(
				appCtx.getResources("classPath:/com/eomcs/lms/mapper/*.xml"));//모든 매퍼.xml로 끝나는 것들
		
		return factoryBean.getObject();		
	}
	
	//2.
	//
/*	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperConfig = new MapperScannerConfigurer();
		mapperConfig.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperConfig.setBasePackage("com.eomcs.lms.dao");
		return mapperConfig;
	}*/
	
	//dao만들기(매퍼파일 자동생성)
	/*@Bean
	public SqlSessionTemplate SqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
  // BoardDao 객체를 만들어 주는 메서드
	//
  @Bean
  public BoardDao boardDao(SqlSessionTemplate sqlSessionTemplete) throws Exception {
    return sqlSessionTemplete.getMapper(BoardDao.class);
  }
  
  //MemberDao 객체를 만들어 주는 메서드
  @Bean
  public MemberDao memberDao(SqlSessionTemplate sqlSessionTemplete) {
	 
    return sqlSessionTemplete.getMapper(MemberDao.class);
  }

  //LessonDao 객체를 만들어 주는 메서드
  @Bean
  public LessonDao lessonDao(SqlSessionTemplate sqlSessionTemplete) {
	    return sqlSessionTemplete.getMapper(LessonDao.class);
  }

  //PhotoBoardDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoBoardDao photoBoardDao(SqlSessionTemplate sqlSessionTemplete) {
	    return sqlSessionTemplete.getMapper(PhotoBoardDao.class);
  }

  //PhotoFileDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoFileDao photoFileDao(SqlSessionTemplate sqlSessionTemplete) {
	  return sqlSessionTemplete.getMapper(PhotoFileDao.class);
  }*/
  }


  








