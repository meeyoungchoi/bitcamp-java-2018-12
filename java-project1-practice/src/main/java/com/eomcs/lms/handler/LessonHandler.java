//13,14, 15,17,18과제
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.ArrayList;

public class LessonHandler {
  Scanner keyboard;

  ArrayList<Lesson> list;
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new ArrayList<>(20);
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
    list.add(lesson);

    System.out.println("저장하였습니다.");

  } 

  public void listLesson() {
    Object[] objects = list.toArray();
    for (Object object : objects) {
      Lesson lesson = (Lesson) object;
      System.out.printf("%d, %s, %s, %s, %d, %d\n",
          lesson.getNum(), lesson.getTitle(), lesson.getStartDate(),
          lesson.getFinishDate(), lesson.getTotalHour(), lesson.getDayHour()
          );
    }
  } 
}


