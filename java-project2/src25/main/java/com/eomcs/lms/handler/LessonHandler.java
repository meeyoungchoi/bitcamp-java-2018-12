package com.eomcs.lms.handler;
import com.eomcs.lms.domain.Lesson;

import java.sql.Date;
import java.util.Scanner;



public class LessonHandler {
	//LessonHandler 클래스를 사용하여 addLesson() 과 listLesson() 메서드를 관리할수 있다.(리펙토링 기법 중에서 클래스 추출 기법을 사용하였다.)

	 Scanner keyboard ;

	 static final int LENGTH = 10;
	
	 //App.java에서 수업관리와 관련된 변수를 LessonHandler클래스로 옯겼다.
	 //addLesson() 과  listLesson() 메서드가 같은 변수를 공유하기 때문에 클래스변수로 만들어 주기위해 static을 붙였다.
	 Lesson[] lessons = new Lesson[LENGTH];
	 int lessonIdx = 0;
	 
	 public LessonHandler(Scanner keyboard) {
		 this.keyboard = keyboard;
	 }
	 
	 public void addLesson() {
		Lesson lesson = new Lesson();
		
		System.out.print("번호? ");
	    lesson.no = Integer.parseInt(keyboard.nextLine());

	    System.out.print("수업명? ");
	    lesson.title = keyboard.nextLine();

	    System.out.print("설명? ");
	    lesson.contents = keyboard.nextLine();

	    System.out.print("시작일? ");
	    lesson.startDate = Date.valueOf(keyboard.nextLine());

	    System.out.print("종료일? ");
	    lesson.endDate = Date.valueOf(keyboard.nextLine());

	    System.out.print("총수업시간? ");
	    lesson.totalHours = Integer.parseInt(keyboard.nextLine());

	    System.out.print("일수업시간? ");
	    lesson.dayHours = Integer.parseInt(keyboard.nextLine());

	    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
	    this.lessons[this.lessonIdx] = lesson;
	    this.lessonIdx++;

	    System.out.println("저장하였습니다.");
	    
		
	}

	public void listLesson() {
		
		for (int j = 0; j < this.lessonIdx; j++) {
	        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
	            this.lessons[j].no, this.lessons[j].title, this.lessons[j].startDate, 
	            this.lessons[j].endDate, this.lessons[j].totalHours);
	      }
	}
}
