//08까지
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class App08과제 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    Member[] members = new Member[LENGTH];
    int membersIdx = 0;
    
    Lesson[] lessons = new Lesson[LENGTH];
    int lessonIdx = 0;
    
    Board[] boards = new Board[LENGTH];
    int boardIdx = 0;

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
          } else if (write.equals("/lesson/add")) {
            
            Lesson lesson = new Lesson();
            
            System.out.print("번호:\n");
            lesson.num = Integer.parseInt(keyboard.nextLine());

            System.out.print("수업명: \n");
            lesson.title = keyboard.nextLine();

            System.out.print("시작일: \n");
            lesson.startDate = Date.valueOf(keyboard.nextLine());

            System.out.print("종료일: \n");
            lesson.finishDate = Date.valueOf(keyboard.nextLine());

            System.out.print("총 수업시간: \n");
            lesson.totalHour = Integer.parseInt(keyboard.nextLine());

            System.out.print("일수업시간: \n");
            lesson.dayHour = Integer.parseInt(keyboard.nextLine());

            //lesson데이터를 배열 래퍼런스에 주입한다.
            lessons[lessonIdx] = lesson;
            lessonIdx++;

            System.out.println("저장하였습니다.");
            
          } else if (write.equals("/lesson/list")) {
            for (int j = 0; j < lessonIdx; j++ ) {
              System.out.printf("%d, %s, %s, %s, %d, %d\n",
                  lessons[j].num, lessons[j].title,lessons[j].startDate,
                  lessons[j].finishDate,lessons[j].totalHour, lessons[j].dayHour
                  );
              }
           } else if (write.equals("/board/add")) {
             Board board = new Board();
             
             System.out.print("번호: \n");
             board.number = Integer.parseInt(keyboard.nextLine());

             System.out.print("내용: \n");
             board.content = keyboard.nextLine();

             board.registeredDate = new Date(System.currentTimeMillis());
             
             board.count = 0;

             boards[boardIdx] = board;
             boardIdx++;
             
             System.out.println("저장하였습니다.");
             
             } else if (write.equals("/board/list")) {
               for (int j = 0; j < boardIdx; j++) {
                 System.out.printf("%d, %s\n",
                     boards[j].number, boards[j].content);
               }
            } else if (write.equals("quit")) {
              System.out.println("종료합니다.");
              break;
            } else {
              System.out.println("실행할 수 없는 명려잉빈다.");
            }
         }
     }
  }
