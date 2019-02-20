package com.eomcs.lms.domain;
import java.sql.Date;

public class Member {//다른 패키지에서 Member클래스의 인스턴스 변수에 접근할수 있게 변수명 앞에 접근제어자 public을 붙인다.
	public int no;
	public String name;
	public String email;
	public String password;
	public String photo;
	public String tel;
	public Date registeredDate;
}
