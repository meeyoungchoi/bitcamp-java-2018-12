package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
	
	static Scanner keyboard = new Scanner(System.in);
	static final int LENGTH = 10;
	
	public static void main(String[] args) {
	 
	while (true) {
      System.out.print("명령> ");
      String command = keyboard.nextLine().toLowerCase();

      if (command.equals("/lesson/add")) {
    	  		LessonHandler.addLesson();
      }	 else if (command.equals("/lesson/list")) {
    	  		LessonHandler.listLesson();
      }	 else if (command.equals("/member/add")) {
    	  MemberHandler.addMember();
      }		else if (command.equals("/member/list")) {
    	  MemberHandler.listMember();
      }		  else if (command.equals("/board/add")) {
    	  BoardHandler.addBoard();
      }	  else if (command.equals("/board2/add")) {
    	  BoardHandler2.addBoard();
      }	else if (command.equals("/board/list")) {
    	  BoardHandler.listBoard();
      }	else if (command.equals("/board2/list")) {
    	  BoardHandler2.listBoard();
      }	else if (command.equals("quit")) {
          System.out.println("안녕!");
          break;
          
        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }
        
        System.out.println(); // 결과 출력 후 빈 줄 출력
      }

      keyboard.close();
    }

}
      
        
        
    
      
      
    