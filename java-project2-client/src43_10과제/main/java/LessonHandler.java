import java.sql.Date;
import java.util.Scanner;

// `App.java` 에서 수업관리와 관련된 변수와 메서드를 `LessonHandler` 클래스로 옮긴다.
public class LessonHandler {
	static Scanner keyboard = new Scanner(System.in);//클래스 변수
	  static final int LENGTH = 10;//클래스 변수
	  
	  static Lesson[] lessons = new Lesson[LENGTH];//클래스 변수
	  static int lessonIdx = 0;//클래스 변수

	  public static void addLesson() {//private에서 static으로 바뀐이유? 클래스메서드
		  //private은 같은 클래스 내에서만 접근이 가능하다.
		  //static 메서드를 만들었다.
		  
		  //클래스 메서드인 addLesson()에서 Lesson.java의 인스턴스 변수에 접근하기 위해 인스턴스를 생성하였다.
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
	  
	 public static void listLesson() {
		    for (int j = 0; j < lessonIdx; j++) {
		      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
		          lessons[j].no, lessons[j].title, lessons[j].startDate, 
		          lessons[j].endDate, lessons[j].totalHours);
		    }
		  }
}
