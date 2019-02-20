//dbms에 연결하기 - java.sql.Driver 구현체 자동 등록
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args)  {
	
		try {
			//java.sql.driver 인터페이스를 구현한 클래스를 로딩하면
			//해당 크랠스에서 자신을 자동으로  DriverManager에게 등록할 것이다.
			//이 방식의 장점은 소스 코드에 특정 클래스를 지정하지 않는다는 것
			//클래스 이름을 문자열로 전달할 수 있기 때문에
			//특정 클래스에 종속되지 않게 작성할 수 있다.
			Class.forName("org.mariadb.jdbc.Driver");//이 이름을 가진 클래스를 메모리에 로딩한다.
			//문자열을 파일에서 받게되면 다른 db에서도 로딩할 수 있다.
			//그러므로 이 프로그램이 특정 클래스에 종속되지 않느다.
			//org.mariadb.jdbc.driver 클래스의 소스를 확인해 보라
			//static 블록에서 driver 객체를 만들어 
			//클래스가 로딩되면 드라이버가 등록된다.
		} catch (Exception e) {
			System.out.println("MariaDB의 java.sql.Driver 구현체를 등록하는 중에 오류 발생");
			e.printStackTrace();
		}
		
		//2. driver 구현체를 이용하여 dbms에 연결한다.
		//dbms에 연결되면 소켓 정보를 갖고 있는 java.sql.connectioln 구현체를 리턴한다.
		//driverManager에게 
		//drivermanager는 이전에 등록된 driver 구현체에게 위임한다.
		//driver 구현체는(org.mariadb.jdbc.Driver 객체)는 dbms와 연결한 후 소켓 정보를 
		//java.sql.connection 구현체에 담아 리턴한다.
		//DriverManager.getConnection(jdbcurl, username, password)
		//jdbcurl => jdbc:(mysql 또는 mariadb)
		//포트 번호를 지정하지 않으면 기본이 3306이다.
		//username => 데이터베이스를 사용할 수 잇는 dbms에 등록된 사용자
		//
		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {
			System.out.println("dbms에 연결 성공");
		} catch (SQLException e) {
			System.out.println("dbms에 연결 중 오류 발생");
			e.printStackTrace();
		}
		
	}
}
