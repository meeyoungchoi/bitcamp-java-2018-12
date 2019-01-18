package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import java.sql.Date;
import java.util.Scanner;

public class LessonHandler {

  static  final int LENGTH = 10;
  Scanner keyboard;
  Lesson[] lessons = new Lesson[LENGTH];
  int lessonIdx = 0;
  
 public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
 public  void addLesson() {
    Lesson lesson = new Lesson();
    
    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle( this.keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(this.keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate( Date.valueOf(this.keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate( Date.valueOf(this.keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours( Integer.parseInt(this.keyboard.nextLine()));

    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    lessons[lessonIdx ] = lesson;
    lessonIdx++;

    System.out.println("저장하였습니다.");
  }

 public void listLesson() {
    
    for (int j = 0; j <  this.lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          this.lessons[j].getNo(), this.lessons[j].getTitle(), this.lessons[j].getStartDate(), 
          this.lessons[j].getEndDate(), this.lessons[j].getTotalHours());
    }
  }
  
}
