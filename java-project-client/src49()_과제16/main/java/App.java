import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboard = new Scanner(System.in);//클래스 변수

  static final int LENGTH = 10;//클래스변수
 
  
  //
 // BoardHandler boardhandler = new BoardHandler();
  public static void main(String[] args) {//클래스 메서드에서 레퍼런스 변수를 사용려면 인스턴스를 생성해야 한다.
	  
	  LessonHandler lessonhandler = new LessonHandler(keyboard);//LessonHanlder생성자에 keyboard객체를 주입한다.
	  
	  MemberHandler memberhandler = new MemberHandler(keyboard);
	  
	  BoardHandler boardhandler = new BoardHandler(keyboard);
	  
	  BoardHandler boardhandler2 = new BoardHandler(keyboard);
	  
	  
    while (true) {
    	
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lessonhandler.addLesson();//레퍼런스를 사용하여 인스턴스 메서드에 접근
        
      } else if (command.equals("/lesson/list")) {
    	  lessonhandler.listLesson();//lessonhandler 레퍼런스를 사용하여 인스턴스 메서드에 접근한다.
      
      } else if (command.equals("/member/add")) {
        memberhandler.addMember();//인스턴스 메서드인 addMember()에 접근하기 위해서는 인스턴스를 생성해야 한다.
        
      } else if (command.equals("/member/list")) {
        memberhandler.listMember();
        
      } else if (command.equals("/board/add")) {
        boardhandler.addBoard();//boardhandler인스턴스를 통해 인스턴스메서드에 접근
       // 참조변수.메스드 
        //인스턴스 메서드 역시 인스턴스를 생성해야만 호출할 수 있다.
        
      } else if (command.equals("/board/list")) {
        boardhandler.listBoard();//boardahandler인스턴스를 통해 인스턴스메서드에 접근
        
      } else if (command.equals("/board2/add")) {
          boardhandler2.addBoard();//클래스 메서드에 접근하려면 클래스이름.메서드이름으로 접근한다.
          
      } else if (command.equals("/board2/list")) {
          boardhandler2.listBoard();//BoardHandler2클래스의 메서드인 listBoard()메서드에 접근
          
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

 

  
  
  }

  

 

  

