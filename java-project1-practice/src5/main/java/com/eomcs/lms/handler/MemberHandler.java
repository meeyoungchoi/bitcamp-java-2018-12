//13,14,15과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  Scanner keyboard;
  
 MemberList list;
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new MemberList();
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

    list.add(member);

    System.out.println("저장하였습니다.");
  }

  public void listMember() {
    Member[] members = list.toArray();
    for (Member member : members) {
      System.out.printf("%d, %s, %s, %d, %s, %s, %s\n",
          member.getNumber(), member.getName(), member.getEmail(), 
          member.getPassword(), member.getPhoto(), member.getTel(),
          member.getLogin() );
    }
  }
}
