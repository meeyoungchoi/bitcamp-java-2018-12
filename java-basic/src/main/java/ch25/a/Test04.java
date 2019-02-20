//dbms에 연결하기 - java.sql.Driver 구현체 조회
package ch25.a;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Test04 {
	public static void main(String[] args)  {
	
	
		try {
			java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");//jdbc에 mariadb를 연결한다.
			System.out.println(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
