package ch29.k1;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//이 클래스는 스프링 IoC 컨테이너를 설정하는 클래스 임을 표시한다.

@Configuration
@MapperScan("ch29.k1.dao")

public class MybatisConfig {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource,
			ApplicationContext appCtx) throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		sqlSessionFactoryBean.setDataSource(dataSource);

		//SQL 매퍼 파일에서 사용하 클래스에 대한 별명을 지정하기
		//=>별명을 자도응로 생성하고 싶은 클래스들이 
		sqlSessionFactoryBean.setTypeAliasesPackage("ch29.k1.vo");

		//
		//=>sqlMapper 파일의 경로는Resource 객체 배열에 담아 넘긴다..
		//=>Resource 객체는 스프링 IoC 컨테이너를 
		sqlSessionFactoryBean.setMapperLocations(appCtx.getResources("classpath:ch29/k1/mapper/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}
}
