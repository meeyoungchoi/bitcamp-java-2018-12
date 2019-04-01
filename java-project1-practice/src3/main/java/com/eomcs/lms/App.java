//13,14과제
package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    //    클래스명.필드명 = 값?
    LessonHandler lessonHandler = new LessonHandler(keyboard);
    //lessonHandler.keyboard = keyboard;
    
    MemberHandler memberHandler = new MemberHandler(keyboard);
    //memberHandler.keyboard = keyboard;
    
    BoardHandler boardHandler = new BoardHandler(keyboard);
    //boardHandler.keyboard = keyboard;
    
    BoardHandler boardHandler2 = new BoardHandler(keyboard);
    //boardHandler2.keyboard = keyboard;

    

    while (true) {

      String command = prompt();
      
   

      if (command.equals("/member/add")) {
        memberHandler.addMember();
      } else if (command.equals("/member/list")) {
        memberHandler.listMember();
      } else if (command.equals("/lesson/add")) {
        lessonHandler.addLesson();
      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();
      } else if (command.equals("/board/add")) {
        boardHandler.addBoard();
      } else if (command.equals("/board/list")) {
        boardHandler.listBoard();
      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();
      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();
      } else if (command.equals("quit")) {
        System.out.println("종료합니다.");
        break;
      } else {
        System.out.println("실행할수 없는 명령 이빈다.");
      }

    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.println("명령>");
    return keyboard.nextLine().toLowerCase();
  }











}

