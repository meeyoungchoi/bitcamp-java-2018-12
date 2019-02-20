package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.lms.handler.BoardHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
      LessonHandler lessonhandler = new LessonHandler(keyboard);
      MemberHandler memberhandler = new MemberHandler(keyboard);
      BoardHandler boardhandler1 = new BoardHandler(keyboard);
    
    while (true) {
      String command = prompt();
   
      if (command.equals("/lesson/add")) {
          lessonhandler.addLesson();
      } else if (command.equals("/lesson/list")) {
        lessonhandler.listLesson();
      } else if (command.equals("/member/add")) {
        memberhandler.addMember();
      } else if (command.equals("/member/list")) {
        memberhandler.listMember();
      } else if (command.equals("/board/add")) {
        boardhandler1.addBoard();
      } else if (command.equals("/board/list")) {
        boardhandler1.listBoard();
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
  System.out.printf("명령>");
  return keyboard.nextLine().toLowerCase();
  }
}
