package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

//이 클래스가 하는 일
//커넥션을 빌려주고 리턴받는 일을 한다.
public class DataSource {

	String driver;
	String jdbcUrl;
	String username;
	String password;

	public DataSource(String driver, String jdbcUrl, String username, String password)  {
		this.driver = driver;
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;
	}

	//한번 생성된 db커넥션 객체를 보관하는 저장소
	ArrayList<Connection> list = new ArrayList<>();

	//커넥션 객체를 현재 스레드에 보관할 수 있도록 보자기를 준비한다.
	//스레드 주머니에 conLOcal이라는 이름으로 커넥션을 저장했다.
	//인스턴스로 바꾼다.
	ThreadLocal<Connection> conLocal = new ThreadLocal<>();

	public Connection getConnection() {
		try {
			Connection con = conLocal.get();
			//현재 스레드 주머니에 들어있는 커넥션 객체 꺼내기
			if (con == null)  {//ArrayList에도 Connection 객체가 없다면,
				if (list.size() == 0) {
					System.out.println("새로 db 커넥션 생성함!");
					con = DriverManager.getConnection(//새로 db커넥션을 생성한다.
							"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
					con.setAutoCommit(false);
					
				} else {//ArrayList에 Connection 객체가 있다면,
					System.out.println("커넥션풀에 보관된 것을 리턴함");
					con = list.remove(0);//ArrayLIst에서 커넥션 객체를 꺼낸다.
				}
				//일단 준비된 Connection 객체는 현재 스레드에서 사용할 수 있도록 주머니에 보관한다.
				conLocal.set(con);//새로 생성한 커넥션 객체를 현재 스레드 주머니에 일단 보관한다.
			} else {
				System.out.println("스레드 주머니에 보관된 커넥션 객체 리턴함.");
			}
			return con;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void returnConnection(Connection con) {
		//다 사용한 커넥션 객체는 다시 재활용할 수 있도록 목록에 보관한다.
		list.add(con);
	}
}
