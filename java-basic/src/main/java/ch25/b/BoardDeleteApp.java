//연습 - 게시물 삭제
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDeleteApp {

	//다음과 같이 게시물 목록 삭제하는 프로그램을 작성하라
	//게시물 번호를 내림차순으로 정렬하라
	//__________------------------------------------------------------------
	// 번호? 1
	//해당 번호의 게시물이 존재하지 않습니다.
	//--------------------------------------------------------------------
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
	

			//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
			//=>java.sql.statement 구현체
			try (Scanner keyboard = new Scanner(System.in);
					Statement stmt = con.createStatement()) {

				System.out.printf("번호를 입력하세요>");
				String no = keyboard.nextLine();
				
				

				//delete 문장은 executeUpdate()를 사용하여 서버에 전달한다.
			int count =	stmt.executeUpdate(
					"delete from x_board where board_id == no");
				//리턴값은 delete 한 레코드의 개수이다.
				System.out.println(count);
				


				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
