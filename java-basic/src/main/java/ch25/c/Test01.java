//Statement 와 sql 삽입공격
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

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

			
			try (Statement stmt = con.createStatement()) {
				//sql 삽입 공격
				//=>입력 문자열에 sql명령을 삽입하여 프로그램의 의도와 다르게 동작하게 하는것
				//사용자가 입력한 값을 자기고 sql문장을 만들 때 이런 문제가 발생한다.
				//번호?1
				//제목?okok
				//내용?"test', view_count = 300, created_date = '2019-3-3"
				 int count = stmt.executeUpdate(
				            "update x_board set title = '" + title
				            + "', contents = '" + contents + "'"
				            + " where board_id = " + no);
				        
				
				 //위에서 사용자가 입력한 값을 가지고 sql문장을 만들면
				 //update x_board set title = 'okok', 
				 //contents =test', view_count = 300, created_date = '2019-3-3'
				 //+ "where board_id = 1
				 //내용 뿐만 아니라 조회수와 날짜도 바뀐다.
				
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
