//insert를 실행한 후 자동 생성된 pk 값 알아내기

package ch26.e;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {
	public static void main(String[] args) throws Exception {

		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/e/mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Board board = new Board();
		board.setTitle("오호라..제목이오!");
		board.setContents("내용이라네요......");
		
		sqlSession.insert("board.insert1", board);
		System.out.println(board);
		System.out.println("===============================================================");
		
		//insert 한 후 자동 생성된 pk 값을 알고 싶으면
		//sql 매퍼 파일에 sql문을 정의할 때 pk 값을 리턴해 다랄고 설정해야 한다.
		sqlSession.insert("board.insert3", board);
		System.out.println(board);//보드의 넘버 프로퍼티에 자동생성된 값이 들어가있다.
		System.out.println("===============================================================");
		
		
		List<Board> boards = sqlSession.selectList("board.select1");
		for (Board b : boards) {
			System.out.println(b);
		}
		System.out.println("===============================================================");
		
		//in-parameter에 int 값 넘기기
		
		//
		//Board board = sqlSession.selectOne("board.select2",5);
		//System.out.println(board);

		//in-parameter String 값 넘기기
		
		//주의
		//mybatis는 auto commit이 false이다.
		//데이터 변경(insert/update/delete) 작업을 수행한 후 반드시 commit()을 호출해야 한다.
				List<Board> boards2 = sqlSession.selectList("board.select3","내용");
				for (Board b : boards2) {
					System.out.println(b);
				}
				System.out.println("===============================================================");

				

	}

}
