package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

//이 클래스가 하는 일
//커넥션을 빌려주고 리턴받는 일을 한다.
public class ConnectionFactory {
	
	//커넥션 객체를 현재 스레드에 보관할 수 있도록 보자기를 준비한다.
	//스레드 주머니에 conLOcal이라는 이름으로 커넥션을 저장했다.
	static ThreadLocal<Connection> conLocal = new ThreadLocal<>();
	
	public static Connection create() {//static context라고 부른다.
		try {
			Connection con = conLocal.get();
			//현재 스레드 주머니에 들어있는 커넥션 객체 꺼내기
			if (con == null)  {
				con = DriverManager.getConnection(
				          "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
				con.setAutoCommit(false);
				conLocal.set(con);//새로 생성한 커넥션 객체를 현재 스레드 주머니에 일단 보관한다.
				return con;
			}
			return conLocal.get();
	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
