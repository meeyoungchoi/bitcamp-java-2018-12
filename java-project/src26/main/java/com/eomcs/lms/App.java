package com.eomcs.lms;


import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;



public class App {
	
	static Scanner keyboard = new Scanner(System.in) ;
	
	
	public static void main(String[] args) {
	 
		// lesson핸들러의 인스턴스를 생성할 때 파라미터의 값으로 keyboard 객체를 넘긴다.
		LessonHandler lessonHandler = new LessonHandler(keyboard);
		// member핸들러의 인스턴스를 생성할 때 파라미터의 값으로 keyboard 객체를 넘긴다.
		MemberHandler memberHandler = new MemberHandler(keyboard);
		//memberHandler.keyboard = keyboard;//?
		
		// board핸들러의 인스턴스를 생성할 때 파라미터의 값으로 keyboard 객체를 넘긴다.
		BoardHandler boardHandler1 = new BoardHandler(keyboard);
		//boardHandler1.keyboard = keyboard;//?
		BoardHandler boardHandler2 = new BoardHandler(keyboard);
		//boardHandler2.keyboard = keyboard;//?
		
		
	while (true) {
      System.out.print("명령> ");
      String command = keyboard.nextLine().toLowerCase();

      if (command.equals("/lesson/add")) {
    	  		lessonHandler.addLesson();
      }	 else if (command.equals("/lesson/list")) {
    	  		lessonHandler.listLesson();
      }	 else if (command.equals("/member/add")) {
    	  		memberHandler.addMember();
      }		else if (command.equals("/member/list")) {
    	  		memberHandler.listMember();
      }		  else if (command.equals("/board/add")) {
    	  		boardHandler1.addBoard();
      }		else if (command.equals("/board/list")) {
    	  		boardHandler1.listBoard();
      } else if (command.equals("/board2/add")) {
    	  		boardHandler2.addBoard();
      }	else if (command.equals("/board2/list")) {
    	  		boardHandler2.listBoard();
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
      
        
        
    
      
      
    