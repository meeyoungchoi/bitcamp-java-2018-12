package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  
  Scanner keyboard;
  static final int LENGTH = 10;
  Member[] members = new Member[LENGTH];//멤버라는 값이 개별적으로 관리될수 있기 때문에 인스턴스 필드로 만든다.
  int memberIdx = 0;
  
  public MemberHandler(Scanner keyboard) {//스태틱 메서드는 this라는 변수가 내장이 안되있어서 인스턴스를 준다하더라도 받을수 없다. 
    this.keyboard = keyboard;
  }
  public void listMember() {//인스턴스 메서드가 되는 순가 this가 내장이 되어 인스턴스를 받을수 있게 된다.
    for (int j = 0; j < this.memberIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].getNo(), members[j].getName(), members[j].getEmail(), 
          members[j].getTel(), members[j].getRegisteredDate());
    }
  }

  public void addMember() {
    Member member = new Member();
    
    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("이름? ");
    member.setName(keyboard.nextLine()); 
    
    System.out.print("이메일? ");
    member.setEmail(keyboard.nextLine()); 
    
    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine()); 
  
    System.out.print("사진? ");
    member.setPhoto(keyboard.nextLine()); 
  
    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());
  
    member.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    members[memberIdx] = member;
    memberIdx++;
    
    System.out.println("저장하였습니다.");
  }
  public Scanner getKeyboard() {
    return keyboard;
  }
  public void setKeyboard(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  public Member[] getMembers() {
    return members;
  }
  public void setMembers(Member[] members) {
    this.members = members;
  }
  public int getMemberIdx() {
    return memberIdx;
  }
  public void setMemberIdx(int memberIdx) {
    this.memberIdx = memberIdx;
  }
  public static int getLength() {
    return LENGTH;
  }

}
