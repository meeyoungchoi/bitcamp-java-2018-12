// Mybatis와 스프링 연동하기 - Java config 사용하여 연동하기
package ch29.k1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch29.k1.dao.BoardDao;
import ch29.k1.vo.Board;

public class Test01 {
	public static void main(String[] args) {

		//java-config를 다룰때는 AnnotationConfigApplicationCOntext 클래스를 사용한다.
		//=>다음과 같이 스프링 IoC 컨테이너를 설정하는 모든 java config 클래스를 지정할 수 있다.
		//그러나 이 방법은 java config 클래ㅡㅅ가 추가도리 때 마다
		//계속 생성자에 그 클래스 정보를 추가해야 하는 번거로움이 발생한다.
		//그래서 실무에서는 보통 main 역할을 하는 java config 클래스 정보만 넘긴다.
		//나머지 java config 클래스들은 @Configuration을 선언하여
		//자신이 스프링 IoC 컨테이너를 설정하는 클래스임을 알린다,
		/*
		ApplicationContext iocContainer = 
				new AnnotationConfigApplicationContext(
						AppConfig.class, DatabaseConfig.class, MybatisConfig.class);

*/
		ApplicationContext iocContainer = 
				new AnnotationConfigApplicationContext(
						AppConfig.class);
		System.out.println("---------------------------------------");

		String[] names = iocContainer.getBeanDefinitionNames();
		for (String name : names) {
			System.out.printf("%s ==> %s\n",
					name, iocContainer.getBean(name).getClass().getName());
		}

		System.out.println("-----------------------------------------------");

		BoardDao boardDao = (BoardDao) iocContainer.getBean("boardDao");
		List<Board> list = boardDao.findAll();
		for (Board b : list) {
			System.out.println(b);
		}

	}
}
