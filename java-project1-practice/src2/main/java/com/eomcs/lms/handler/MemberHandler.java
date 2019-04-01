//10,11과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  public static Scanner keyboard;
  
  static final int LENGTH = 10;
  
  static Member[] members = new Member[LENGTH];
  static int membersIdx = 0;
  
  public static void addMember() {
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

  public static void listMember() {
    for (int j = 0; j < membersIdx; j++) {
      System.out.printf("%d, %s, %s, %d, %s, %s, %s\n",
          members[j].number,members[j].name, members[j].email, 
          members[j].password,members[j].photo, members[j].tel,
          members[j].login );
    }
  }
}
