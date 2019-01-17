package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.BoardHandler2;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    // 외부로 분리한 클래스에서 사용할 keyboard를 주입한다.
    LessonHandler lessonhandler = new LessonHandler(keyboard);
    MemberHandler memberhandler = new MemberHandler (keyboard);
    BoardHandler boardhandler = new BoardHandler (keyboard);//외부에서 보드핸들러를 사용하려면 스캐너 객체를 주입해야 한다.
    
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lessonhandler.addLesson();//addLesson():인스턴스메서드
     //  인스턴스 이름으로 인스턴스 메서드를 호출한다.   
      } else if (command.equals("/lesson/list")) {
        lessonhandler.listLesson();
      
      } else if (command.equals("/member/add")) {
        memberhandler.addMember();
        
      } else if (command.equals("/member/list")) {
        memberhandler.listMember();
        
      } else if (command.equals("/board/add")) {
        boardhandler.addBoard();
        
      } else if (command.equals("/board/list")) {
        boardhandler.listBoard();
        
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
