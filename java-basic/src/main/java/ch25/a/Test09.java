//java.sql.ResultSet 객체 - 서버에서 select를 가져오기 3
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test09 {
	public static void main(String[] args)  {


		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
			System.out.println("dbms에 연결됨");

			//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
			//=>java.sql.statement 구현체
			try (Statement stmt = con.createStatement()) {


				//executeQuery()의 리턴 값은 ResultSet 구현체 이다.
				//ResultSet객체?
				//=>서버의 select 실행 결과를 가져올 때 사용하는 도구이다.
				//단 한 개씩 가져온다. 한번에 모두 가져오는 것이 아니다.
				try 	(ResultSet rs =	stmt.executeQuery(
						"select * from x_board order by board_id desc")) {

					//next():
					//서버에서 한 개의 row(record)를 가져온다.
					//만약 가져올 레코드가 없으면 false를 리턴한다.
					while (rs.next()) {
						//레코드에서 컬럼 값을 꺼낼 때 컬럼의 타입에 상관업이 무조거누문자열로 받을 수 있다.
						//
						System.out.printf("%s, %s, %s, %s, %s\n",
								rs.getString("board_id"),//board_id 
								rs.getString("title"),//title
								rs.getString("contents"), //contents
								rs.getString("created_date"), //created_date
								rs.getString("view_count"));//view_count
					}


				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
