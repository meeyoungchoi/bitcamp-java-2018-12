//mybatis 설정하기
//1. Mybatis 라이브러리 파일을 프로젝트에 등록하기
//-mavenrepository.com에서 mybatis검색하여 라이브러리 정보 알아낸다
//-build.gradle 파일에 의존 라이브러리 정보를 추가한다.
//-gralde-eclipse를 실행하여 라이브러리를 다운로드 받고, 이클립스 설정 파일에 등록
//리프레시 
//refrenced libraries 에서 mybatis가 들어와있는지 확인
//2.mybatis 설정 파일 준비
//-mybatis.org
//Mybatis 설정 파일예)-mybatis-config.xml을 생성한다.
//-문서 페이지를 참조하여 설정 파일의 내용을 변경한다.
//3. sql 메퍼 파일 준비
//mybatis.org사이트에서 문서 페이지를 참조한다.
//sql이 들어있는 파일(예: BoardMapper.xml)을 생성한다.
//문서 페이지를 참조하여 
//4.select 결과를 저장할 클래스 정의
//ch26.a.BOard.클래스 생성
//필드는 컬럼의 이름과 같게 한다.
//5.select SQL을 실행
//-MYBATIS 문서 페이지를 참조한다.
//관련 객체를 생성하고 사용하여 SQL을 실행한다.
package ch26.a;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
	public static void main(String[] args) throws Exception {
		
		
		//1.MYBATIS 설정 파일을 읽을 때 사용할 도구를 준비한다.
		//파일 입력 스트림 객체 준비
		//FILEINPUTSTRAEM 객체를 직접 생성해도 되지만,
		//직접 생성하려면 설정 파일의 전체 경로를 정확하게 지정해야 한다.
		//예) c:/users/user/bitcamp-2018-12/java-basic/src/main/java/ch26/a/mybatis-config.xml
		//만약 결로가 바뀌면 소스의 경로를 다시 변경해야 하는 문제가 있다.
		//마이바티스 설정 파일이 자바 클래스 파일(.class)처럼 classpath에 있다면
		//resources.getResourcesAsStream()을 호출하여 입력 스트림을 준비하는 것이 더 편하다.
		//마이바티스가 자바 클래스파일들이 있는 경로에 존재하는 경우
		String resource = "ch26/a/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//만약 Resources.getResourceAsStream()을 사용하지 않는다면 다음과 같이
		//직접 FileInputStream을 생성해야 한다.
		//만약 설정파일이 다른 위치에 있다면 적어줘야 한다.(java클래스 파일이 있는 패키지가 아닌 다른 위치에 있다면)
		InputStream inputStream2 = new FileInputStream(
				"/home/meeyoungchoi/git/bitcamp-java-2018-12/java-basic/src/main/java/ch26/a/mybatis-config.xml");
		
		//2.mybatis 설정 파일에 따라 동작할 sql 실행 도구를 준비한다.
		//=> sqlsessionFactoryBuilder : sqlSessionFactory를 만들어 주는 일 (자동차)
		//builder 디자인 패턴이 적용되어 있다.
		//-여러 객체를 조립하여 한 객체를 생성하는 경우, 직접 하는 대신에 그 일을 해주는 객체 '빌더'를 통해 생성하는 것이 유지보수에 좋다.
		//=>sqlSessiolnFactory: sqlsession객체를 만들어 주는 일을 한다. (김밥)
		//-factory method 디자인 패턴이 적용되어 있다.
		//객체 생성 과정이 복잡할 경우 메서드를 통해 객체를 생성하는 것이 유지보수에 좋다.
		
		
		//sqlsession: sql 매퍼 파일에 보관된 sql을 찾아 실행해주는 일을 한다.
		
		SqlSessionFactory sqlSessionFactory =//new SqlSessionFactory(inputStream); 이렇게 만들수도 있지만 향후 확장성을 위해서 builder를 통해서 만드는게 더낳다고 판단.
		  new SqlSessionFactoryBuilder().build(inputStream);
		
		//SqlSession sqlSession = new SqlSession();이런식으로 하면 관리하기 힘들다.
		
		//3) 팩토리 메서드를 통해 객체를 생성한다.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//4. sql 매퍼 파일에 보관된 sql 문을 찾아 실행한다.
		//파라미터 값은 sql 문의 id이다.
		//sql 매퍼 파일의 namespace 값과 sql id 값을 결합해서 지정한다.
		//selectList()의 리턴 값은 sql 매퍼 파일의 resultTypte에 지정된 객체를 담고 있는 list객체이다.
		List<Board> list = sqlSession.selectList("board.select1");
		
		//5.출력
		for (Board b : list) {
			System.out.printf("%d, %s, %s, %s, %d\n",
					b.getBoard_id(),
					b.getTitle(),
					b.getContents(),
					b.getCreated_date(),
					b.getView_count());
		}
	}

}
