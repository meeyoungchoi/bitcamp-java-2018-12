package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;//여기에서 <Lesson> 이렇게 정의해 놓으면 public E[] toArray(E[] a)   public void add(E obj) 로

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
  
  //addLesson에 입력된 값을 꺼내서 보여줘야 한다.
  //Lesson배열의 인덱스 값을 list[size]로 옮겼다.
  //list[index] 요소에 값이 저장되어있다.
  //index: 값을 꺼낼 배열 항목의 위치
  @SuppressWarnings("unused")
  public void detailLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index)) 
      return ;
    
    Lesson lesson = list.get(index);
    
    if (lesson == null) {
      System.out.print("해당 수업을 찾을수 없습니다.");
      return;//메서드를 호출한 쪽으로 되돌아가라
    }
    System.out.printf("수업명: %s \n",lesson.getTitle());
    System.out.printf("수업내용: %s\n",lesson.getContents());
    System.out.printf("기간: %s ~ %s \n",lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %s \n",lesson.getTotalHours());
    System.out.printf("일수업시간: %s\n",lesson.getDayHours());

   }

  public void deletelLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index)) 
      return ;
 
    Lesson lesson = list.get(indexOf(no));
    
   if (lesson == null) {
      System.out.print("해당 수업을 찾을수 없습니다.");
      return;
    }
    
    list.remove(index);
    System.out.print("수업을 삭제했습니다.");
  }

  public void updatelLesson() {//중복되는 코드는 메서드로 뽑아내야 한다.
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index)) 
      return ;
    
    Lesson lesson = list.get(indexOf(no));
    Lesson temp = new Lesson();
    
    temp.setNo(lesson.getNo());
      
    System.out.printf("수업명: (%s) \n",lesson.getTitle());
    String input = (keyboard.nextLine());
    if (input.length() > 0 ) {
        temp.setTitle(input);
     } else {
       temp.setTitle(lesson.getTitle());
     }
      
      System.out.printf("수업내용? ");
      input = (keyboard.nextLine());
      temp.setContents(input.length() > 0 ? input : lesson.getContents());
      
      System.out.printf("시작일(%s)?  \n",lesson.getStartDate());
      input = (keyboard.nextLine());
      temp.setStartDate(input.length() > 0 ? 
          Date.valueOf(input ) : lesson.getStartDate());
      
      System.out.printf("종료일(%s)? ",lesson.getEndDate());
      input = (keyboard.nextLine());
      temp.setEndDate(input.length() > 0 ? 
          Date.valueOf(input ) : lesson.getEndDate());
      
      System.out.printf("총수업시간(%d)? ",lesson.getTotalHours());
      input = (keyboard.nextLine());
      temp.setTotalHours(input.length() > 0 ? (Integer.parseInt(input  ))  : lesson.getTotalHours());
      
      System.out.printf("일수업시간(%d)? \n",lesson.getDayHours());
      input = (keyboard.nextLine());
      temp.setDayHours(input.length() > 0 ? (Integer.parseInt(input  ))  : lesson.getDayHours());
      
      list.set(index, temp);
    
  }
  
  private int indexOf(int lessonNo) {

    for (int i = 0; i < list.size(); i++) {
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
  
  private boolean validate(int index) {
    if (index == -1) {
      System.out.print("해당 수업을 찾을수 없습니다.");
      return false;
    }
    return true;
   }
}
