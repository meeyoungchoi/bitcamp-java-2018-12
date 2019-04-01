//13,14,15과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  Scanner keyboard;
  
  final int LENGTH = 10;
  
  Member[] members = new Member[LENGTH];
  int membersIdx = 0;
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void addMember() {
    Member member = new Member();

    System.out.print("번호: \n");
    member.setNumber(Integer.parseInt(keyboard.nextLine()));

    System.out.print("이름: \n");
    member.setName(keyboard.nextLine());

    System.out.printf("이메일: \n");
    member.setEmail(keyboard.nextLine());

    System.out.print("암호: \n");
    member.setPassword(Integer.parseInt(keyboard.nextLine()));

    System.out.print("사진: \n");
    member.setPhoto(keyboard.nextLine());

    System.out.print("전화: \n");
    member.setTel(keyboard.nextLine());

    member.setLogin(new Date(System.currentTimeMillis()));

    members[membersIdx] = member;
    membersIdx++;

    System.out.println("저장하였습니다.");
  }

  public void listMember() {
    for (int j = 0; j < this.membersIdx; j++) {
      System.out.printf("%d, %s, %s, %d, %s, %s, %s\n",
          this.members[j].getNumber(), this.members[j].getName(), this.members[j].getEmail(), 
          this.members[j].getPassword(), this.members[j].getPhoto(), this.members[j].getTel(),
          this.members[j].getLogin() );
    }
  }
}
