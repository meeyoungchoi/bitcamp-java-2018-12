package com.eomcs.lms.handler;


import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.ArrayList;

public class LessonHandler {

  static final int LENGTH = 10;
  
  Scanner keyboard;
  ArrayList<Lesson> list;// Lesson 타입의 ArrayList
 
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<Lesson>(20);
  }
  
  public void listLesson() {
	  Lesson[] lessons = list.toArray(new Lesson[] {});//Lesson[] lessons
    for (Lesson lesson : lessons) {//Lesson lesson : lessons
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(),
          lesson.getTotalHours());
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
	System.out.println("번호");
	int no = Integer.parseInt(keyboard.nextLine());
	
	Lesson lesson = null;//Lesson 클래스의 인스턴스값이 없으면
	for (int i = 0; i < list.size(); i++) {//Lesson타입의  ArrayList배열의 방의번호보다 작을때가지 돌다가
		Lesson l = list.get(i);//Lesson타입의 ArrayList배열에서 가져온 값을 l인스턴스에 넣는다.
		if (l.getNo() == no) {//만약 l 인스턴스로 가져온 번호가 입력받은 번호와 일치한다면
		lesson = l;//l인스턴스의 주소를 lesson인스턴스에 저장한다.
		break;
		}
	}
	if (lesson == null) {
		System.out.println("해당 수업을 찾을 수 없습니다.");
		return;
	}	
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getContents());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
	
}

public void updateLesson() {
	System.out.println("번호:");
	int no = Integer.parseInt(keyboard.nextLine());
	
	Lesson lesson = null;
	int index = -1;//
	for (int i = 0; i < list.size(); i++) {// lesson타입의 list배열의 배열요소보다 작을때까지
		Lesson l	=	list.get(i);
		if (l.getNo() == no) {
			lesson = l;
			index = i;
	       break;
		}
	}
	
	if (lesson == null) {
		System.out.println("해당 수업을 찾을 수 없다.");
		return;
	}
	//일단 기존 값을 복제한다.
	//복제할 Lesson클래스의 인스턴스를 만들어줘야 한다.
	Lesson temp = new Lesson();//temp인스턴스를 생성한다.
	//인스턴스메서드에 접근을 하려면 참조변수.메서드
	//lesson인스턴스에 저장되어있는 getNo()메서드를 호출해서 값을 가져온다.
	//이 값을 가져와서 복제하려는 인스턴스인 temp의 setNo메서드에 넣어준다.
	temp.setNo(lesson.getNo());
	temp.setTitle(lesson.getTitle());
	temp.setContents(lesson.getContents());
	temp.setStartDate(lesson.getStartDate());
	temp.setEndDate(lesson.getEndDate());
	temp.setDayHours(lesson.getDayHours());
	temp.setTotalHours(lesson.getTotalHours());
	
	//위에서 복제된 내용을 get으로 가져와서 출력해서 보여줘야 한다.
	//업데이트 내용을 입력을 받아야 한다.
	//업데이터 내용이 입력이 되어있다면 그 내용을 출력해야 한다.
	
	System.out.printf("수업명(%s)? ", lesson.getTitle());
    String input = keyboard.nextLine();
    if (input.length() > 0) 
      temp.setTitle(input);
    
    System.out.printf("설명(%s)? ", lesson.getContents());
    if ((input = keyboard.nextLine()).length() > 0)
      temp.setContents(input);
    
    System.out.printf("시작일(%s)? ", lesson.getStartDate());
    if ((input = keyboard.nextLine()).length() > 0)
      temp.setStartDate(Date.valueOf(input));
    
    System.out.printf("종료일(%s)? ", lesson.getEndDate());
    if ((input = keyboard.nextLine()).length() > 0)
      temp.setEndDate(Date.valueOf(input));
    
    System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
    if ((input = keyboard.nextLine()).length() > 0)
      temp.setTotalHours(Integer.parseInt(input));
    
    System.out.printf("일수업시간(%d)? ", lesson.getDayHours());
    if ((input = keyboard.nextLine()).length() > 0)
      temp.setDayHours(Integer.parseInt(input));
    
    list.set(index, temp);
    
    System.out.println("변경하였습니다.");
  }
	
public void deleteLesson() {
	System.out.println("번호");
	int no = Integer.parseInt(keyboard.nextLine());
	
	int index = -1;
	for (int i = 0; i < list.size(); i++) {
	Lesson l	= list.get(i);//get(i)?
	if (l.getNo() == no) {
		index = i;
		break;
	}
}
	
	if (index == -1) {
		System.out.println("해당 수업을 찾을수 없다.");
		return;
	}
	
	list.remove(index);
	
	System.out.println("수업을 삭제했습니다.");
	}
}
