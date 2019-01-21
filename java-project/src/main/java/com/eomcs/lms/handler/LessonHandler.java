package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[] {});
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));

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

    list.add(lesson);

    System.out.println("저장하였습니다.");
  }

  public void detailLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if(!validate(index))
      return;
    
    Lesson lesson = list.get(index);

    
   if (lesson == null) {
     System.out.println("해당 수업을 찾을 수 없습니다.");
     return;
   }
   
   System.out.printf("수업명? %s",lesson.getTitle());
   System.out.printf("수업내용? %s",lesson.getContents());
   System.out.printf("기간? %s ~ %s",lesson.getStartDate(), lesson.getEndDate());
   System.out.printf("총수업시간? %d",lesson.getTotalHours());
   System.out.printf("일수업시간? %d",lesson.getDayHours());
    
  }

  private boolean validate(int index) {
   if (index == -1) {
     System.out.println("해당 수업을 찾을 수 없습니다.");
     return false;
   }
    return true;
 }

  private int indexOf( int lessonNo) {
    for (int i = 0; i<list.size(); i++) {
      Lesson item = list.get(i);
      if (item.getNo() == lessonNo) {
        return i;
      }
    }
    return -1;
  }

  private int promptLessonNo() {
    System.out.print("번호?");
    return Integer.parseInt(keyboard.nextLine());
    
  }

  public void updatelesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
   Lesson lesson = list.get(index);
   Lesson temp = new Lesson();
   
  temp.setNo(lesson.getNo());
  
  System.out.printf("수업명(%s)?",lesson.getTitle());
  String input = keyboard.nextLine();
  if (input.length() > 0) {
    temp.setTitle(input);
  } else {
    temp.setTitle(lesson.getTitle());
  }
  
  System.out.printf("수업내용? ");
  input = keyboard.nextLine();
  temp.setContents(input.length() > 0 ? input : lesson.getContents());
  
  System.out.printf("시작일(%s)?",lesson.getStartDate());
  input = keyboard.nextLine();
  temp.setStartDate(input.length() > 0 ?
      Date.valueOf(input) : lesson.getStartDate());
  
  System.out.printf("종료일(%s)?",lesson.getEndDate());
  input = keyboard.nextLine();
  temp.setEndDate(input.length() > 0 ?
      Date.valueOf(input) : lesson.getEndDate());
  
  System.out.printf("총수업시간(%d)?",lesson.getTotalHours());
  input = keyboard.nextLine();
  temp.setTotalHours(input.length() > 0 ?
      Integer.parseInt(input) : lesson.getTotalHours());
   
  System.out.printf("일수업시간(%d)?", lesson.getDayHours() > 0 ?
      Integer.parseInt(input) : lesson.getDayHours());
  
  list.set(index, temp);
  }

  public void deletelesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    list.remove(index);
    System.out.println("수업을 삭제했습니다.");
    }
}
