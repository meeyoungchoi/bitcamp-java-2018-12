//update 실행하기
package ch26.e;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {
	public static void main(String[] args) throws Exception {

		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/e/mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//insert 문을 실행할 때는 insert() 메서드를 호출하라
		//그러나 update delete 메서드를 호출해도 된다.
		//왜? insert, update, delete 모두 jdbc에서 executeUpdate()를 호출하기 때문이다.
		//
		Board board = new Board();//값을 여러개 넘기고 싶으면 객체에 담아서 념겨자
		board.setNo(5);
		board.setTitle("xxxxxxxx");
		board.setContents("내용이라네요......");
		
		
		//insert(sql, ind 파라미터 값을 담은 객체)
		//리턴 값은 insert 된 row의 개수이다.
		int count = sqlSession.update("board.update", board);//그런 아이디를 갖는 id가 없을때 애러Mapped Statements collection does not contain value for board.update
		System.out.println(count);

		HashMap<String,Object> board2 = new HashMap<>();
		board2.put("title", "오호...제목");
		board2.put("contents", "오호...내용");
		count = sqlSession.insert("board.insert2", board2);
		System.out.println(count);
		
		
		
		//in-parameter 값을 넘기지 않고 sql 실행하기
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
