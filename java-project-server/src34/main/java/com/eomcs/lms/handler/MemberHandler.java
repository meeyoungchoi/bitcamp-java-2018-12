package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
 
  Scanner keyboard;
  MemberList list;
  
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new MemberList(20);
  }
  
  public void listMember() {
	   Object[] objs = list.toArray();//Member[] members
    for (Object obj : objs) {//Member member : members
    	Member member = (Member) obj;//형변환
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(),
          member.getRegisteredDate());
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
    
    //members[memberIdx] = member;
    //memberIdx++;
    list.add(member);//add() 메서드 호출
    
    System.out.println("저장하였습니다.");
  }

}
