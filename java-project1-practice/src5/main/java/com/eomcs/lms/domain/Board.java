//11, 15과제
package com.eomcs.lms.domain;

import java.util.Date;

public class Board {

 private int number;
 private String content;
 private int count;
 private Date registeredDate;
 
public int getNumber() {
  return number;
}
public void setNumber(int number) {
  this.number = number;
}
public String getContent() {
  return content;
}
public void setContent(String content) {
  this.content = content;
}
public int getCount() {
  return count;
}
public void setCount(int count) {
  this.count = count;
}
public Date getRegisteredDate() {
  return registeredDate;
}
public void setRegisteredDate(Date registeredDate) {
  this.registeredDate = registeredDate;
}
 
 
  
}
