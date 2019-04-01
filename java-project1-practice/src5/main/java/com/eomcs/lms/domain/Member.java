//11,15과제
package com.eomcs.lms.domain;

import java.util.Date;

public class Member {
  
  private int number;
  private String name;
  private String email;
  private int password;
  private String photo;
  private String tel;
  private Date login;
  
  public int getNumber() {
    return number;
  }
  public void setNumber(int number) {
    this.number = number;
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
  public int getPassword() {
    return password;
  }
  public void setPassword(int password) {
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
  public Date getLogin() {
    return login;
  }
  public void setLogin(Date login) {
    this.login = login;
  }
  
  
}
