//selectOne() 과 selectList()

package ch26.d;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ch26.d.Board;

public class Test01 {
	public static void main(String[] args) throws Exception {
		
		//1.
		//
		//2.
		//
		//3.
		//
		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/d/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
	
		//selectList()
		//여러 개의 결과 값을 리턴하는 select를 실행할 때 사용한다.
		//select 실행으로 생성된 각 row의 값은 resultType에 지정한 클래스의 인스턴스에 저장된다.
		//그리고 그 인스턴스는 list구현체에 담겨 리턴된다.
		//
		List<Board> list = sqlSession.selectList("board.select1");
		
		for (Board b : list) {
			System.out.printf("%d, %s, %s, %s, %d\n",
					b.getBoard_id(),
					b.getTitle(),
					b.getContents(),
					b.getCreated_date(),
					b.getView_count());
		}
		System.out.println("================================================");
		
		//selectOne()
		//한개의 결과 값을 리턴하는 select를 실행할 때 사용한다.
		//만약 여러 개의 결과가 리턴된느 select를 실행한다면 예외가 발생한다.
		
		//board.select1 sql문은 여러 개의 결과 값이 리턴되기 때문에
		//selectOne()으로 
		//Board board = sqlSession.selectOne("board.select1");//select된 결과가 너무 많다=>애러 : Expected one result (or null) to be returned by selectOne(), but found: 24
		Board board = sqlSession.selectOne("board.select2");//ok
		System.out.println(board);
	}

}
