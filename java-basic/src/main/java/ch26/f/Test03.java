//dynamic sql 다루기 - where 태그의 용도 where태그 사용전
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {
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

		//여러 개의 조건으로 검색하기
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
		value = keyboard.nextLine();
		if (value.length() > 0) {
			params.put("title", value);
		}
		keyboard.close();





		List<Board> boards = sqlSession.selectList("board.select3",params);


		for (Board b : boards) {
			System.out.println(b);
		}
		System.out.println("===============================================================");


	}
}

	




