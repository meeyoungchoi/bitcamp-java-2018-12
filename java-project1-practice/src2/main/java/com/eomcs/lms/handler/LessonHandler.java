//10,11과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {
  public static Scanner keyboard;
  
  static final int LENGTH = 10;

  static Lesson[] lessons = new Lesson[LENGTH];
  static int lessonIdx = 0;
 

    
    public static void addLesson() {

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

    } 
    
    public static void listLesson() {
      for (int j = 0; j < lessonIdx; j++ ) {
        System.out.printf("%d, %s, %s, %s, %d, %d\n",
            lessons[j].num, lessons[j].title,lessons[j].startDate,
            lessons[j].finishDate,lessons[j].totalHour, lessons[j].dayHour
            );
      }
    } 
  }
  

