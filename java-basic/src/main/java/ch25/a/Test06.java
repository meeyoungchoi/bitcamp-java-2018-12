//java.sql.Statement 객체 - SQL을 DMBS 서버에 전달한다.
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test06 {
	public static void main(String[] args)  {


		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
			System.out.println("dbms에 연결됨");

			//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
			//=>java.sql.statement 구현체
			try (Statement stmt = con.createStatement()) {

				//statement 구현체를 이요하여 sql문을 서버에 전달한다.
				//executeUpdate(): insert, update, delete 등 ddl, dms 문법을 전달한다.
				//executeQuert(): select 문법을 전달한다.
				//execute(): 모든 sql문을 전달한다.
				//executeBatch(): 여러 개의 sql을 전달한다.
				//
			int count =	stmt.executeUpdate("insert into x_board(title,contents)"
						+ "values('제목10','내용')");
			
			//executeUpdate()의 리턴 값은 sqlㅇ르 실행한 후 입력, 변경, 삭제된
			//row(=record)의 개수이다.
			System.out.println(count);
				System.out.println("입력 성공!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
