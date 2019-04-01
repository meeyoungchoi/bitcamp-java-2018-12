//11,15과제
package com.eomcs.lms.domain;

import java.util.Date;

public class Lesson {

  private int num;
  private String title;
  private Date startDate;
  private Date finishDate;
  private int totalHour;
  private int dayHour;
  
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getFinishDate() {
    return finishDate;
  }
  public void setFinishDate(Date finishDate) {
    this.finishDate = finishDate;
  }
  public int getTotalHour() {
    return totalHour;
  }
  public void setTotalHour(int totalHour) {
    this.totalHour = totalHour;
  }
  public int getDayHour() {
    return dayHour;
  }
  public void setDayHour(int dayHour) {
    this.dayHour = dayHour;
  }


}
