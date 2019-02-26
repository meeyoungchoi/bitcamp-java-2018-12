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
 * */
public class LessonHandler {
	static Scanner keyboard = new Scanner(System.in);//클래스 변수
	  static final int LENGTH = 10;//클래스 변수
	  
	  Lesson[] lessons = new Lesson[LENGTH];//인스턴스 변수
	  int lessonIdx = 0;//인스턴스 변수

	  public void addLesson() {//인스턴스 메서드로 전환

		    Lesson lesson = new Lesson();//인스턴스생성

		    System.out.print("번호? ");
		    lesson.no = Integer.parseInt(keyboard.nextLine());//인스턴스의 멤버변수에 접근
		//   참조변수.멤버변수

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
		    lessons[lessonIdx] = lesson;
		    lessonIdx++;

		    System.out.println("저장하였습니다.");
		  }
	  
	 public void listLesson() {//인스턴스 메서드로 전환
		    for (int j = 0; j < lessonIdx; j++) {
		      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
		          lessons[j].no, lessons[j].title, lessons[j].startDate, 
		          lessons[j].endDate, lessons[j].totalHours);
		    }
		  }
}
