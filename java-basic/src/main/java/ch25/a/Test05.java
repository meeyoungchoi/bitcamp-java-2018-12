//java.sql.Connection 객체
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
//,"bitcamp","1111"
public class Test05 {
	public static void main(String[] args)  {
	
	
		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
			
			System.out.println("dbms에 연결됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
