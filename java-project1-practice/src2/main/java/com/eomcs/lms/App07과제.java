//07까지
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class App07과제 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    Member[] members = new Member[LENGTH];

    int membersIdx = 0;

    while (true) {



      Member member = new Member();

      System.out.println("명령>");
      String write = keyboard.nextLine();

      if (write.equals("/member/add")) {



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
        
      } else if (write.equals("/member/list")) {
        for (int j = 0; j < membersIdx; j++) {
          System.out.printf("%d, %s, %s, %d, %s, %s, %s\n",
              members[j].number,members[j].name, members[j].email, 
              members[j].password,members[j].photo, members[j].tel,
              members[j].login );
              }
          }
     // keyboard.close(); 
        }
    
    }
}
