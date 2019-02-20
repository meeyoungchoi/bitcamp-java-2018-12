import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.domain.Lesson;//컴파일러에게 소스팡리에 사용된 클래스의 패키지에 대한 정보를 제공하는 것이다.
//import문을 사용하여 클래스 명을 명시하면 클래스의 단순명을 사용하여 참조할수 있다.

// 10.`App.java` 에서 수업관리와 관련된 변수와 메서드를 `LessonHandler` 클래스로 옮긴다.
//	11.  데이터 타입 클래스를 별도의 패키지로 분류하라.
/*
 *  도메인 패키지 생성
    - `com.eomcs.lms.domain` 패키지 생성
- 도메인 클래스를 `domain` 패키지로 이동
    - `Lesson`, `Member`, `Board` 클래스를 `com.eomcs.lms.domain` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- 핸들러 클래스에 import 문 추가
    - `LessonHandler`, `MemberHandler`, `BoardHandler` 클래스를 변경한다.
 * 
 * 12.  LessonHandler.java
    - 변수와 메서드를 인스턴스 멤버로 전환한다.
    
    13. 핸들러 객체의 필수 입력 값인 keyboard를 반드시 설정하게 만들라!
    	기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
    	
    15.  LessonHandler.java
    - Lesson 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.
    	
 * */
public class LessonHandler {
		
	  static final int LENGTH = 10;//클래스 변수
	  
	  Lesson[] lessons = new Lesson[LENGTH];//인스턴스 변수
	  int lessonIdx = 0;//인스턴스 변수
	  Scanner keyboard;
	  
	  public LessonHandler(Scanner keyboard) {//기본생성자 대신에 파라미터값으로 keyboard를 받는 생성자를 추가한다.
		  this.keyboard = keyboard;
	  }

	  public void addLesson() {//인스턴스 메서드로 전환

		    Lesson lesson = new Lesson();//인스턴스생성

		    System.out.print("번호? ");
		    lesson.setNo(Integer.parseInt(keyboard.nextLine()));//인스턴스의 멤버변수에 접근
		//   참조변수.멤버변수

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
		    lessons[lessonIdx] = lesson;
		    lessonIdx++;

		    System.out.println("저장하였습니다.");
		  }
	  
	 public void listLesson() {//인스턴스 메서드로 전환
		    for (int j = 0; j < lessonIdx; j++) {
		      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
		          lessons[j].getNo(), lessons[j].getTitle(), lessons[j].getStartDate(), 
		          lessons[j].getEndDate(), lessons[j].getTotalHours());
		    }
		  }
}
