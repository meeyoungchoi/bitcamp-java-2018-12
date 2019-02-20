package com.eomcs.lms.domain;
import java.io.Serializable;
import java.sql.Date;

public class Member implements Cloneable, Serializable {
  private static final long serialVersionUID = 1L;//시리얼라이즈 할때 이 클래스가 몇번쨰 버전인지를 알려준다.
  //저장된 클래스와 내가 읽으려는 클래스를 조정하기 위해서 시리얼버전유아이디를 적는다.
  //이걸 적지않으면 클래스 마다 시리얼버전 유아이디가 달라진다.
  //버전이바뀌지 않으면 같은 클래스로 취급한다.
  //transient modifier
  
  private int no;
  private String name;
  private String email;
  private String password;
  private String photo;
  private String tel;
  private Date registeredDate;
  
  @Override
  public Member clone() throws CloneNotSupportedException {
    return (Member) super.clone();
  }
  
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

@Override
public String toString() {
	return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", photo=" + photo
			+ ", tel=" + tel + ", registeredDate=" + registeredDate + "]";
}
  
  
}
