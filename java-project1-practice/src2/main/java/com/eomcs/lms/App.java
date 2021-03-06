//10,11,12과제
package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.BoardHandler2;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    //    클래스명.필드명 = 값?
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    BoardHandler2.keyboard = keyboard;
    

    while (true) {

      String command = prompt();
      
      BoardHandler boardHandler = new BoardHandler();

      if (command.equals("/member/add")) {
        MemberHandler.addMember();
      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();
      } else if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();
      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
      } else if (command.equals("/board/add")) {
        boardHandler.addBoard();
      } else if (command.equals("/board/list")) {
        boardHandler.listBoard();
      } else if (command.equals("/board2/add")) {
        boardHandler.addBoard();
      } else if (command.equals("/board2/list")) {
        boardHandler.listBoard();
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

