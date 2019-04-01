//06까지
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    //Lesson 타입의 lesson 객체를 다루기 위한 lessons 배열 생성
    //lessons 배열안에 객체의 주소가 저장된다.
    //즉 객체를 다루기 위한 참조현수들이 만들어진 것일 뿐 아직 객체가 생성되지는 않았다.
    Lesson[] lessons = new Lesson[LENGTH];

    int lessonIdx = 0;

    while (true) {

      //따라서 lesson 객체를 생성해 줘야 한다.
      Lesson lesson = new Lesson();

      System.out.println("명령>");
      String write = keyboard.nextLine();

      if (write.equals("/lesson/add")) { 

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

      } else  if (write.equals("/lesson/list")) {
        for (int j = 0; j < lessonIdx; j++ ) {
          System.out.printf("%d, %s, %s, %s, %d, %d\n",
              lessons[j].num, lessons[j].title,lessons[j].startDate,
              lessons[j].finishDate,lessons[j].totalHour, lessons[j].dayHour
              );
        }
      }

    }

  }

}
