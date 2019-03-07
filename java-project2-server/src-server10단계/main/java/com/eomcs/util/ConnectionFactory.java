package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

//이 클래스가 하는 일
//커넥션을 빌려주고 리턴받는 일을 한다.
public class ConnectionFactory {
	
	public static Connection create() {
		try {
	return DriverManager.getConnection(
		          "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
