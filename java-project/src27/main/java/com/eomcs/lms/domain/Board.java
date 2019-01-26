package com.eomcs.lms.domain;

import java.sql.Date;
//다른 패키지에서 변수에 접근할 수 있도록 접근 제어자를 public으로 변경한다.
//lms 패키지에서 domain 패키지에 있는 변수에 접근할 수 있도록 board클래스 변수의 접근 제어자를 public으로 변경했다.

public class Board {
  private int no;
  private String contents;
  private Date createdDate;
  private int viewCount;
 
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public int getViewCount() {
	return viewCount;
}
public void setViewCount(int viewCount) {
	this.viewCount = viewCount;
}
}
