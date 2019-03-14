//sql을 실행할 때 파라미터값 넘기기

package ch26.e;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
	public static void main(String[] args) throws Exception {

		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/e/mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//in-parameter 값을 넘기지 않고 sql 실행하기
		List<Board> boards = sqlSession.selectList("board.select1");//sql아이디
		for (Board b : boards) {
			System.out.println(b);
		}
		System.out.println("===============================================================");
		
		//in-parameter에 int 값 넘기기
		
		//
		Board board = sqlSession.selectOne("board.select2",5);
		System.out.println(board);
System.out.println("=============================================================================================");
		//in-parameter String 값 넘기기
				List<Board> boards2 = sqlSession.selectList("board.select2",5);//sql아이디 다음에 값을 주면된다.
				for (Board b : boards2) {
					System.out.println(b);
				}
				System.out.println("===============================================================");


	}

}
