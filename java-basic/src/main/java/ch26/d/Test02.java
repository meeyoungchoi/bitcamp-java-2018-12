//select 결과 값을 자바 인스턴스에 담는 규칙

package ch26.d;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {
	public static void main(String[] args) throws Exception {
		
		InputStream inputStream = Resources.getResourceAsStream(
				"ch26/d/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//mybatis의 sqlSession이 board.select3 sql문을 실행한 후
		//그 결과는 sql 매퍼 파일에 지정된 대로 ch26.d.Board2 인스턴스에 담아 리턴한다.
		
		
		//그런데 다음과 같이 전혀 다른 타입의 레퍼런스로 받으려하면 오류가 발생한다.
		//Board board = sqlSession.selectOne("board.select3");//실행오류
		
		//Board2클래스의 인스턴스에 저장한다.
		Board2 board = sqlSession.selectOne("board.select3");
		System.out.println(board);
		
		//Mybatis에서 select 결과를 자바 인스턴스에 담을 떄 규칙
		//컬럼 이름과 같은 프로터피를 찾아서 값을 담는다.
		//프로퍼티?
		//자바에서 프로퍼티란?
		//세터/게터를 가리키는 용어다.
		//예) setNo()/getNo()
		//프로퍼티 이름?
		//세터/게터 이름에서 set/get 이름ㅇ르 제거한 후, 나머지 이름이다.
		//단 첫 알파벳은 소문자이다.나머지 이름 중에서 첫 알파벳을 소문자로 바꾼 이름이다.
		//예) setNo()/getNo() => no
		//예) setCreatedDate()/getCreatedDate() => createdDate
		//주의!
		//필드 이름이 프로퍼티 이름이 아니다!
		//필드는 필드다
		//세터 게터가 프로퍼티 이름이다.
		
		//결론
		//Board2 클래스의 프로퍼티 이름을 보면 no, title, contents, createdDate, viewCount가 있다.
		//이 프로퍼티 중에서 컬럼 이름과 같은 프로퍼티는 title, contents 이다.
		//그래서 Mybatis는 컬럼 이름과 같은 이름을 가진 프로퍼티(title과 contents)에 대해서만 결과 값을 넣어 준다.
		//그래서 Board2 객체를 출력해보면 title과 contents 값만 정상적으로 출력된다.
		//
		//해결책?
		//컬럼 이름과 프로퍼티 명을 같게 하면 되지 않겟는가?
		//db의 이름짓는 규칙과 자바의 이름 짓는 규칙은 다르다.
		//dbms 마다 또 이름 짓는 규칙이 다르다.
		//그래서 자바에서 프로퍼티 이름을 지을 때 특정 dbms에 종속되게 지어서는 안되낟.
		//자바는 자바의 명명 규칙을 따르고, db는 dbms의 명명 규칙을 따른면 된다.
		//
		//select
		
		
		
	}

}
