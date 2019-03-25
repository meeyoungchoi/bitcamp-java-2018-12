package com.eomcs.lms;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration//이 클래스가 스프링 IoC 컨테이너를 설정하는 java config 클래스 임을 표시한다.
@MapperScan("com.eomcs.lms.dao") 
public class MybatisConfig {

	// SqlSessionFactory를 생성하는 메서드
	@Bean
	public SqlSessionFactory sqlSessionFactory(
			DataSource dataSource,
			ApplicationContext appCtx) throws Exception {

		// mybatis에서 SqlSessionFactory를 생성할 때 사용하라고 제공하는 객체이다. 
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

		// SqlSessionFactory 객체를 생성하는데 필요한 객체를 주입한다.
		factoryBean.setDataSource(dataSource);

		// 도메인 클래스의 별명을 자동을 생성하도록 도메인 클래스가 들어 있는 패키지를 지정한다.
		factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");

		// SQL 매퍼 파일이 있는 패키지를 등록한다.
		factoryBean.setMapperLocations(
				appCtx.getResources("classpath:/com/eomcs/lms/mapper/*.xml"));

		return factoryBean.getObject();
	}




}






