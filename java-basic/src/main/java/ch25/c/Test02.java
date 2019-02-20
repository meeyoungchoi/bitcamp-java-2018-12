//preparedStatement를 이용하여 sql 삽입공격 차단하기
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {

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

			
			//preparedStatement는 미리 sql 문장을 준비하여 값을 삽입하는 방법이다.
			try (PreparedStatement stmt = con.prepareStatement(
					"update x_board set title = ?, contents = ? where board_id = ?")) {
				//sql 문장을 준비할 때, 값이 들어갈 자리에 ? 로 표시한다.
				//?를 "in-prarmeter"라 부른다.
				//값을 넣는 파라미터
				//sql을 서버에 전달하기 전에 in-parameter 자리에 값을 넣는다.
				//preparedStatement.setXxxx(in-parameter 인덱스, 값);
				// -XXxxx: 컬럼의 타입에 따라 setInt(), setString(), setDate() 등
				//숫자 값을 삽입할 때
				//-in-parameter 인덱스: ? 문자가 등장하는 순서대로  1부터 번호를 부여한다.
				//-값: sql 문장에 삽입될 값이다. 실제 sql 문장과 별도로 서버에 전달되기 때문에 
				//문자열 값 중간에 '(작은 따옴표)가 포함 되더라도 sql 문에 영향을 끼치지 않는다.
				//작은 따옴표를 그냥 일반 문자로 취급한다.
				//
				//=>in-parameter 값을 설정할 때 순서대로 할 필요는 없다.
				//
				
				stmt.setString(3, no);
				stmt.setString(1, title);
				stmt.setString(2, contents);
				
				
				 int count = stmt.executeUpdate(
				            "update x_board set title = '" + title
				            + "', contents = '" + contents + "'"
				            + " where board_id = " + no);
				        
				
					//preparedStatement에서는 sql문을 서버에 보낼때는 파라미터로 전달하지 않는다.
				if (count == 0) {
					System.out.println("번호에 해당하는 내용이 없습니다.");
				} else {
			          System.out.println("변경하였습니다.");
		        }
				//기술면접
				//statement vs preparedstatement
				//1. sql 문장의 간결함
				//statement : 값을 가지고 문자열로 직접 sql 문을 만들기 때문에 작성하거나 읽기 힘들다.
				//preparedstatement : sql 문장과 값이 분리되어 있기 때문에 작성하거나 읽기 쉽다.
				//2.sql 삽입 공격
				//statement: 사용자가 입력한 값을 가지고 sql문장을 만들기 때문에 해킹되기 쉽다.
				//preparedstatement: sql 문장과 값이 분리되어 다루어지기 때문에 해킹할 수 없다.
				//3.바이너리 데이터 다루기
				//statement: 문자열로 sql 문장을 만들기 때문에 바이트 배열의 값을 다룰 수 없다.
				//preparedStatement : setXxxx() 메서드를 호출하여 값을 설정하기 때문에
				//바이트 배열의 값을 다룰수 있다.
				//4. 실행속도
				//Statement : executeUpdate()를 실행할 때 마다 sql문을 파라미터로  전달한다.
				//호출될 때마다 sql문법을 분석하기 때문에 반복 실행하는 경우 sql문법도 반복 분석하므로 실행 속도가 느리다.
				//서버로 보내기 전에 매번 sql 문법을 컴파일 해야 한다.
				//sql이 서버로 보내지기 전에 검사되어서 보내진다,
				//prepardStatement:미리 sql문을 작성한 다음에
				//값을 넣은 후 executeUpdate()를 호출한다.
				//따라서 executeUpdate()를 호출할 때 마다 sql 문법을 분석하지 않으므로 반복 실행할 때 statement 보다 빠르다.
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
