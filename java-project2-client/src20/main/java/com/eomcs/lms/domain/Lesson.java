package com.eomcs.lms.domain;

import java.sql.Date;

public class Lesson {
	//lms package의 LessonHandler.java에서 domain 패키지의 Lesson 클래스의 변수에 
	//접근할 수 있도록 Lesson 클래스의 변수에 접근 제어자 public을 븉였다.
  public int no;
  public String title;
  public String contents;
  public Date startDate;
  public Date endDate;
  public int totalHours;
  public int dayHours;
}
