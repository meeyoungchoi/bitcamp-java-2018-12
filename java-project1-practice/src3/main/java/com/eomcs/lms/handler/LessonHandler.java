//13,14과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {
  Scanner keyboard;

  final int LENGTH = 10;

  Lesson[] lessons = new Lesson[LENGTH];
  int lessonIdx = 0;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void addLesson() {

    Lesson lesson = new Lesson();

    System.out.print("번호:\n");
    lesson.num = Integer.parseInt(keyboard.nextLine());

    System.out.printf("수업명:  \n");
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

  } 

  public void listLesson() {
    for (int j = 0; j < this.lessonIdx; j++ ) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n",
          this.lessons[j].num, this.lessons[j].title, this.lessons[j].startDate,
          this.lessons[j].finishDate,this.lessons[j].totalHour, this.lessons[j].dayHour
          );
    }
  } 
}


