package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.ArrayList;
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

	//static final int LENGTH = 10;//클래스 변수
	Scanner keyboard;
	ArrayList<Lesson> list;//LessonList 타입의 list 인스턴스 생성
	

	public LessonHandler(Scanner keyboard) {//기본생성자 대신에 파라미터값으로 keyboard를 받는 생성자를 추가한다.
		this.keyboard = keyboard;
		this.list = new ArrayList<>(20);//LessonList() 생성자를 호출하려면 인스턴스를 생성해야 하므로 인스턴스를 생성하였다.
	}

	public void listLesson() {//수업 데이터 배열을 리턴
		// Object[] objs = list.toArray();//인스턴스 메서드 toArray()에 접근
		Lesson[] lessons = list.toArray(new Lesson[] {});//배열 레러런스?
		for (/*Object obj : objs*/Lesson lesson : lessons) {//objs배열에 저장된 값이 반복문이 실행될때 마다 
			//하나씩 순서대로 읽혀서 Object 타입의 obj변수에 저장된다.
			//Lesson lesson = (Lesson) obj;//lesson레퍼런스가 가리키는 실제 Lesson타입을 그대로 사용하고 싶다면 => 형변환 하여 사용하라
			//즉, 컴파일러에게 obj에 들어있는 주소가 원래 Lesson의 인스턴스이다 라고 알려줘야 한다.
			//그러니 obj에 들어있는 주소를 Lesson타입의 lesson인스턴스에 저장하렴
			System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
					lesson.getNo(), lesson.getTitle(), lesson.getStartDate(), 
					lesson.getEndDate(), lesson.getTotalHours());
		}
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

		//수업 데이터를 저장하는 add() 메서드 호출
		list.add(lesson);

		System.out.println("저장하였습니다.");
	}

	

	public void detailLesson() {
		System.out.print("번호>");
		int no = Integer.parseInt(keyboard.nextLine());

		int index = indexOfLesson(no);
		if (index == -1) {
			System.out.println("번호에 해당하는 수업을 찾을수 없습니다.");
			return;
		}

		Lesson lesson = list.get(index);
		System.out.printf("수업명: %s\n",lesson.getTitle());
		System.out.printf("설명: %s\n",lesson.getContents());
		System.out.printf("기간: %s ~ %s\n",lesson.getStartDate() , lesson.getEndDate());
		System.out.printf("총 수업시간: %d\n ",lesson.getTotalHours());
		System.out.printf("일 수업시간: %d\n",lesson.getDayHours());
	}

	private int indexOfLesson(int no) {
		for	 (int i = 0; i < list.size(); i++ ) {//list.size(): 입력받아서 저장된 listLesson의 크기
			Lesson l	= list.get(i);
			if (l.getNo() == no) {
				return i;
			}
		}
		return -1;
	}

	public void updatelesson() {
		System.out.print("번호>");
		int no = Integer.parseInt(keyboard.nextLine());

		int index = indexOfLesson(no);
		if (index == -1) {
			System.out.println("번호에 해당하는 수업을 찾을수 없습니다.");
			return;
		}

		 Lesson lesson = list.get(index);
		    
		    try {
		      // 일단 기존 값을 복제한다.
		      Lesson temp = lesson.clone();
		      
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
		      
		      System.out.println("수업을 변경했습니다.");
		      
		    } catch (Exception e) {
		      System.out.println("변경 중 오류 발생!");
		    }

	}

	public void deleteLesson() {
		System.out.println("번호>");
		int no = Integer.parseInt(keyboard.nextLine());

		int index	= indexOfLesson(no);
		if (index == -1) {
			System.out.println("일치하는 번호가 없습니다.");
			return;
		}
		
		list.remove(index);
		
		System.out.println("수업을 삭제했습니다.");
		}
}
