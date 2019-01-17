package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;
import java.sql.Date;
import java.util.Scanner;

public class MemberHandler {
  Scanner keyboard;
  
  static  final int LENGTH = 10;
  static   Member[] members = new Member[LENGTH];
  static int memberIdx = 0;
 
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void listMember() {
    
    for (int j = 0; j < this.memberIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
           this.members[j].getNo(), this.members[j].getName(), this.members[j].getEmail(), 
          this.members[j].getTel(), this.members[j].getRegisteredDate());
    }
    
  }
 
  public void addMember() {
    Member member = new Member();
    
    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("이름? ");
    member.setName(keyboard.nextLine());
    
    System.out.print("이메일? ");
    member.setEmail( keyboard.nextLine());
    
    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine()); 

    System.out.print("사진? ");
    member.setPhoto( keyboard.nextLine());

    System.out.print("전화? ");
    member.setTel( keyboard.nextLine());

    member.setRegisteredDate( new Date(System.currentTimeMillis())); 
    
    members[memberIdx] = member;
    memberIdx++;
    
    System.out.println("저장하였습니다."); 
    
  }
}
