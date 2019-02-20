package com.eomcs.lms.domain;
import java.sql.Date;

public class Board {//다른 패키지에서 Lesson클래스의 인스턴스 변수에 접근할수 있도록 변수명 앞에 접근 제어자 public을 붙인다.
	public int no;
	public String contents;
	public Date createdDate;
	public int viewCount;
}
