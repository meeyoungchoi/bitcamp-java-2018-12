//연습 - 게시물 변경
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BoardUpdateApp {

	//다음과 같이 게시물 목록 변경하는 프로그램을 작성하라
	//게시물 번호를 내림차순으로 정렬하라
	//__________------------------------------------------------------------
	// 번호? 1
	//제목? xxxx
	//내용?XXXXXX
	//ENTER
	//변경하였습니다.
	//해당 번호의 게시물이 존재하지 않습니다.
	//--------------------------------------------------------------------
	public static void main(String[] args) {

		String no = null;
		String title = null;
		String contents = null;
		
		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.print("번호>");
			no = keyboard.nextLine();
			
			System.out.print("제목>");
			title = keyboard.nextLine();
			
			System.out.println("내용>");
			contents = keyboard.nextLine();
			
			
		}
		try (Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){

			//connection 객체를 통해 sql을 dbms에 전달할 때 사용할 도구를 얻는다.
			//=>java.sql.statement 구현체
			try (Statement stmt = con.createStatement()) {

				 int count = stmt.executeUpdate(
				            "update x_board set title = '" + title
				            + "', contents = '" + contents + "'"
				            + " where board_id = " + no);
				        
				
				
				if (count == 0) {
					System.out.println("번호에 해당하는 내용이 없습니다.");
				} else {
			          System.out.println("변경하였습니다.");
		        }
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
