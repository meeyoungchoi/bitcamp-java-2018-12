package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;
//사진게시물을 넣고 뺼때 그릇으로 사용할 데이터 타입
//사진 게시물 데이터를 다룰 데이터타입

public class PhotoBoard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int no;
	  private String title;
	  private Date createdDate;
	  private int viewCount;
	  private int lessonNo;
	  
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
	public int getLessonNo() {
		return lessonNo;
	}
	public void setLessonNo(int lessonNo) {
		this.lessonNo = lessonNo;
	}
	  
	  
}
