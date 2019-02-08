import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboard = new Scanner(System.in);//클래스 변수

  static final int LENGTH = 10;//클래스변수
 
  public static void main(String[] args) {
	  //외부로 옮긴 클래스에서도 사용할수 있도록 키보드 주입
	  LessonHandler.keyboard = keyboard;//keyboard가 클래스 변수이므로 LessonHandler클래스d의 keyboard클래스 변수에 접근해서 keyboard를 사용할수 있게 한다. keyboard객체를 주입한다.
	  MemberHandler.keyboard = keyboard;//MemberHandler클래스에서 keyboard 클래스 변수에 접근하여 keyboard를 사용할할수 있도록 keyboard객체를 주입한다.
	  BoardHandler.keyboard = keyboard;//BoardHandler클래스에서 keyboard 레퍼펀스에 접근하여 keyboard를 사용할수 있도록 keyboard객체를 주입한다.
	  BoardHandler2.keyboard = keyboard;
	  
    while (true) {
    	
      String command = prompt();

      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();//클래스 메서드에 접근할 때는 객체를 생성하지 않고도 접근할수 있다.
        
      } else if (command.equals("/lesson/list")) {
       LessonHandler.listLesson();
      
      } else if (command.equals("/member/add")) {
        MemberHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();
        
      } else if (command.equals("/board/add")) {
        BoardHandler.addBoard();//클래스 메서드에 접근하려면 클래스이름.메서드이름으로 접근한다.
        
      } else if (command.equals("/board/list")) {
        BoardHandler.listBoard();
        
      } else if (command.equals("/board2/add")) {
          BoardHandler2.addBoard();//클래스 메서드에 접근하려면 클래스이름.메서드이름으로 접근한다.
          
      } else if (command.equals("/board2/list")) {
          BoardHandler2.listBoard();//BoardHandler2클래스의 메서드인 listBoard()메서드에 접근
          
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

  

 

  

