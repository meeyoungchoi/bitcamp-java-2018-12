package com.eomcs.lms.domain;//
import java.sql.Date;

/*
 * 15. : Lesson 인스턴스의 값을 다룰 연산자를 정의하라.
 * 			Lesson.java
    - 인스턴스 변수(필드)를 비공개(private)로 전환한다.
    - 값을 설정하고 리턴해주는 세터/게터를 정의한다. 
 * 
 * */
public class Lesson implements Cloneable {

  private int no;
  private String title;
  private String contents;
  private Date startDate;
  private Date endDate;
  private int totalHours;
  private int dayHours;
  
  @Override
public Lesson clone() throws CloneNotSupportedException {
		return (Lesson) super.clone();
	}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public int getTotalHours() {
	return totalHours;
}
public void setTotalHours(int totalHours) {
	this.totalHours = totalHours;
}
public int getDayHours() {
	return dayHours;
}
public void setDayHours(int dayHours) {
	this.dayHours = dayHours;
}
  
  
  
  
}
