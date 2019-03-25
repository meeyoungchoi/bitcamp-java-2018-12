package ch29.k4;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//MybatisConfig 이 클래스는 스프링 IoC 컨테이너를 설정하는 클래스임을 표시한다.
@Configuration

//Mybatis와 스프링 IoC 컨테이너를 연동하는 설정
//=>Mybatis관련 빈 설정

//Mybatis DAO 구현체 자동 생성하기
//@MapperScan(DAO 인터페이스가 들어 있는 패키지)
@MapperScan("ch29.k1.dao")
public class MybatisConfig {
	
	//Mybatis의 SqlSessionFactory sqlSessionFactory 객체 준비
	@Bean
	  public SqlSessionFactory sqlSessionFactory(
	      DataSource dataSource, ApplicationContext appCtx) throws Exception {
		
		//SqlSessionFactoryBean은 SqlSessionFactory객체를 생성해준다.
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		//DataSource를 주입한다.
		 sqlSessionFactoryBean.setDataSource(dataSource);
		 
		 //sql 매퍼 파일 위치 지정
		    sqlSessionFactoryBean.setMapperLocations(
		            appCtx.getResources("classpath:ch29/k1/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
}
