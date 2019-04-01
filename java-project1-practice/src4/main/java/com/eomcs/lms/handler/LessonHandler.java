//13,14, 15과제
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
    lesson.setNum(Integer.parseInt(keyboard.nextLine()));

    System.out.printf("수업명:  \n");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("시작일: \n");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일: \n");
    lesson.setFinishDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총 수업시간: \n");
    lesson.setTotalHour(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간: \n");
    lesson.setDayHour(Integer.parseInt(keyboard.nextLine()));

    //lesson데이터를 배열 래퍼런스에 주입한다.
    lessons[lessonIdx] = lesson;
    lessonIdx++;

    System.out.println("저장하였습니다.");

  } 

  public void listLesson() {
    for (int j = 0; j < this.lessonIdx; j++ ) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n",
          this.lessons[j].getNum(), this.lessons[j].getTitle(), this.lessons[j].getStartDate(),
          this.lessons[j].getFinishDate(),this.lessons[j].getTotalHour(), this.lessons[j].getDayHour()
          );
    }
  } 
}


