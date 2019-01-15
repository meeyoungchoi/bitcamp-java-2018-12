package com.eomcs.lms;

import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.BoardHandler2;
import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    LessonHandler lessonhandler = new LessonHandler();
    LessonHandler.keyboard = keyboard;
    
    MemberHandler memberhandler = new MemberHandler();
    MemberHandler.keyboard = keyboard;
    
    BoardHandler board1 = new BoardHandler();
    board1.keyboard = keyboard;
    
    BoardHandler2 board2 = new BoardHandler2();
    board2.keyboard = keyboard;
 
    
    while (true) {
      String command = prompt();
   
      

      if (command.equals("/lesson/add")) {
          LessonHandler.addLesson();
      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
      } else if (command.equals("/member/add")) {
        MemberHandler.addMember();
      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();
      } else if (command.equals("/board/add")) {
        board1.addBoard();
      } else if (command.equals("/board/list")) {
        board1.listBoard();
      } else if (command.equals("/board2/add")) {
        board2.addBoard();
      }  else if (command.equals("/board2/list")) {
        board2.listBoard();
      }
      else if (command.equals("quit")) {
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
  System.out.printf("명령>");
  return keyboard.nextLine().toLowerCase();
  }
}
