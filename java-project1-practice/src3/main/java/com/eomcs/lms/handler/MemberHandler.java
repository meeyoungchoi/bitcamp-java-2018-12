//13,14과제
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
    member.number = Integer.parseInt(keyboard.nextLine());

    System.out.print("이름: \n");
    member.name = keyboard.nextLine();

    System.out.printf("이메일: \n");
    member.email = keyboard.nextLine();

    System.out.print("암호: \n");
    member.password = Integer.parseInt(keyboard.nextLine());

    System.out.print("사진: \n");
    member.photo = keyboard.nextLine();

    System.out.print("전화: \n");
    member.tel = keyboard.nextLine();

    member.login = new Date(System.currentTimeMillis());

    members[membersIdx] = member;
    membersIdx++;

    System.out.println("저장하였습니다.");
  }

  public void listMember() {
    for (int j = 0; j < this.membersIdx; j++) {
      System.out.printf("%d, %s, %s, %d, %s, %s, %s\n",
          this.members[j].number, this.members[j].name, this.members[j].email, 
          this.members[j].password, this.members[j].photo, this.members[j].tel,
          this.members[j].login );
    }
  }
}
