//dynamic sql 다루기 - <choose> 태그 사용
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {
	public static void main(String[] args) throws Exception {

		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/f/mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//dynamic sql?
		//조건에 따라 sql이 변경되는 것
		//mybatis는 이를 위해 조건문, 반복문 등을 다룰 수 있도록 특별한 태그를 제공한다.


		HashMap<String,Object> params = new HashMap<>();

		//여러 개의 조건 중 한 개에 대해 처리하기
		Scanner keyboard = new Scanner(System.in);
		System.out.print("게시물 번호? ");
		String value = keyboard.nextLine();
		
		try {
			params.put("no", Integer.parseInt(value));
		} catch (Exception e) {
			
		}


		System.out.print("제목? ");
		value = keyboard.nextLine();
		if (value.length() > 0) {
			params.put("title", value);
		}

		System.out.println("내용?");
		String conts = keyboard.nextLine();
		if (value.length() > 0) {
			params.put("contents", conts);
		}
		keyboard.close();





		List<Board> boards = sqlSession.selectList("board.select5",params);


		for (Board b : boards) {
			System.out.println(b);
		}
		System.out.println("===============================================================");


	}
}

	




