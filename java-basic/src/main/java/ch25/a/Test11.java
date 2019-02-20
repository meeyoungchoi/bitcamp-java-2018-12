//java.sql.Statement - delete 실행하기 
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test11 {
	public static void main(String[] args)  {


		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
			System.out.println("dbms에 연결됨");

			//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
			//=>java.sql.statement 구현체
			try (Statement stmt = con.createStatement()) {


				//delete 문장은 executeUpdate()를 사용하여 서버에 전달한다.
			int count =	stmt.executeUpdate(
					"delete from x_board where board_id > 5");
				//리턴값은 delete 한 레코드의 개수이다.
				System.out.println(count);
				


				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
