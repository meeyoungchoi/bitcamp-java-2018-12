// MyBatis와 스프링 연동하기 - xml 사용하여 연동하ㅣㄱ
package ch29.k2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch29.k2.dao.BoardDao;
import ch29.k2.vo.Board;

public class Test01 {
	public static void main(String[] args) {

		//xml 설정 파일을 설정할 때는 ClassPathXmlApplicationCOntext 클래스를 이용한다.
		ApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext(
						"ch29/k2/application-context.xml",
						"ch29/k2/database-context.xml",
						"ch29/k2/mybatis-context.xml");
		
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
