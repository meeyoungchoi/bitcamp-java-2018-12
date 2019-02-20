package com.eomcs.lms.domain;
import java.io.Serializable;
import java.sql.Date;

public class Member implements Cloneable, Serializable {
	  private static final long serialVersionUID = 1L;
	  
	  private int no;
	  private String name;
	  private String email;
	  private String password;
	  private String photo;
	  private String tel;
	  private Date registeredDate;
	  
	  public Member() {
	  }
	  
	  public Member(int no, String name) {
	    this.no = no;
	    this.name = name;
	  }
	  
	  @Override
	  public Member clone() throws CloneNotSupportedException {
	    return (Member) super.clone();
	  }
	  
	  @Override
	  public String toString() {
	    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
	        + ", photo=" + photo + ", tel=" + tel + ", registeredDate=" + registeredDate + "]";
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
	  
	  
	}
