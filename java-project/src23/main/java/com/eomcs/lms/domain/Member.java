package com.eomcs.lms.domain;

import java.sql.Date;

public class Member {
	//lms 패키지에있는 BoardHandler 클래스에서 domain 패키지에있는 Member 클래스의 변수에
	//접근할 수 있도록 Member 클래스의 접근제어자를 public으로 변경했다.
  public int no;
  public String name;
  public String email;
  public String password;
  public String photo;
  public String tel;
  public Date registeredDate;
}
