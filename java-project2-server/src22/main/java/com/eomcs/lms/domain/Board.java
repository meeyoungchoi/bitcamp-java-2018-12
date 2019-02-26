package com.eomcs.lms.domain;

import java.sql.Date;
//다른 패키지에서 변수에 접근할 수 있도록 접근 제어자를 public으로 변경한다.
//lms 패키지에서 domain 패키지에 있는 변수에 접근할 수 있도록 board클래스 변수의 접근 제어자를 public으로 변경했다.

public class Board {
  public int no;
  public String contents;
  public Date createdDate;
  public int viewCount;
}
