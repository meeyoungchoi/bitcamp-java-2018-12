//dbms에 연결하기 - java.sql.Driver 구현체 자동 등록 2.
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test03 {
	public static void main(String[] args)  {
	
	//드라이버 메니저의 getConnection()을 호출할 때
		//드라이버 매니저는 java.jdbcURL 정보를 바탕으로 java.sql.Driver구현체를 찾는다.
		//즉 개발자가 코드로 java.sql.driver 구현체를 직접 등록하지 않아도
		//또는 java.sql.Driver를 구현한 클래스를 로딩하지 않아도
		//자동 로딩한다.
		//어떻게?
		//1.jvm이 알고있는 모든 .jar 파일을 뒤진다.
		//2. jar 파일 안에 meta-inf/services/java.sql.driver 파일을 찾는다.
		//3.이 파일에 등록된 클래스를 로딩한다.
		//org.mariadb.jdbc.Driver이 클래스를 로딩한다.
		//그래서 개발자가 따로 java.sql.Driver 구현체를 등록하지 않아도 된다.
		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {
			System.out.println("dbms에 연결 성공");
		} catch (SQLException e) {
			System.out.println("dbms에 연결 중 오류 발생");
			e.printStackTrace();
		}
		
	}
}
