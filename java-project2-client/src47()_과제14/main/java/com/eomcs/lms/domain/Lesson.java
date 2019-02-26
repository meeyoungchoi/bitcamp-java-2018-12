package com.eomcs.lms.domain;//
import java.sql.Date;

public class Lesson {
	//다른 패키지에서 domain 패키지의 Lesson.java의 인스턴스 변수에 접근할 수 있도록 접근제어자를 public으로 변경한다.
  public int no;
  public String title;
  public String contents;
  public Date startDate;
  public Date endDate;
  public int totalHours;
  public int dayHours;
}
