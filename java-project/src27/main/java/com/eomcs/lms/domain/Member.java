package com.eomcs.lms.domain;

import java.sql.Date;

public class Member {
//Member 인스턴스의 값을 다룰 연산자를 정의하기 위해서 
//인스턴스 변수(필드)를 비공개(private)로 전환한다.
  public int no;
  public String name;
  public String email;
  public String password;
  public String photo;
  public String tel;
  public Date registeredDate;
  
//Board 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public Date getRegisteredDate() {
	return registeredDate;
}
public void setRegisteredDate(Date registeredDate) {
	this.registeredDate = registeredDate;
}
 }
