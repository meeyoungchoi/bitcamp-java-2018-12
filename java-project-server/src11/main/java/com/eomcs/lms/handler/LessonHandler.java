package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  Scanner keyboard;//스캐너 인스턴스
  static final int LENGTH = 10;
  static Lesson[] lessons = new Lesson[LENGTH];
  int lessonIdx = 0;//인스턴스 필드
  

  //키보드를 반드시 입력받야야 하므로 공개된 생성자
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;//디스가 가리키는 인스턴스에 키보드가 가리키는 파라미터(변수) 값을 넣는다.
  }
  
  public void listLesson() {//인스턴스 메서드
    for (int j = 0; j < this.lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          this.lessons[j].getNo(), this.lessons[j].getTitle(), this.lessons[j].getStartDate(), 
          this.lessons[j].getEndDate(), this.lessons[j].getTotalHours());
    }
  }

  public void addLesson() {//인스턴스 메서드
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));
    //레퍼런스.인스턴스 필드
    
    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());
    

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));  

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    this.lessons[this.lessonIdx] = lesson;
    this.lessonIdx++;

    System.out.println("저장하였습니다.");
  }
  
  public void LessonList() {
    
  }
  
  

  public Scanner getKeyboard() {
    return keyboard;
  }

  public void setKeyboard(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public static Lesson[] getLessons() {
    return lessons;
  }

  public static void setLessons(Lesson[] lessons) {
    LessonHandler.lessons = lessons;
  }

  public int getLessonIdx() {
    return lessonIdx;
  }

  public void setLessonIdx(int lessonIdx) {
    this.lessonIdx = lessonIdx;
  }

  public static int getLength() {
    return LENGTH;
  }
}
