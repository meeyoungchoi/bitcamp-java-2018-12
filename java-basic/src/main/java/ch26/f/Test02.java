//dynamic sql 다루기 - 조건문2

package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {
	public static void main(String[] args) throws Exception {

		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/f/mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//dynamic sql?
		//조건에 따라 sql이 변경되는 것
		//mybatis는 이를 위해 조건문, 반복문 등을 다룰 수 있도록 특별한 태그를 제공한다.
		
		//조건문 사용하기
		//파란미터 값을 맵 객체에 담아 전달하기
		Scanner keyboard = new Scanner(System.in);
		System.out.print("게시물 번호? ");
		String value = keyboard.nextLine();
		keyboard.close();
		
		HashMap<String,Object> params = new HashMap<>();
		
		params.put("no", value);
		
		try {
			params.put("no", Integer.parseInt(value));
			//숫자로 바꿀 수 있으면 맵에 "no"이름으로 값이 저장될 것이고,
			//숫자로 바꿀 수 없으면 맵dp "no"이름의 값이 없을 것이다.
		} catch (Exception e) {}
		List<Board> boards = sqlSession.selectList("board.select2",params);
		
		try {
			boards = sqlSession.selectList("board.select1", Integer.parseInt(value));
		} catch (Exception e) {
			boards = sqlSession.selectList("board.select1");
		}

		for (Board b : boards) {
			System.out.println(b);
		}
		System.out.println("===============================================================");
		
	}
}
