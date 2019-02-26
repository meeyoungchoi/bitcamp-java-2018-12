package com.eomcs.lms;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;


public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();
  
  public static void main(String[] args) {
	 LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(keyboard, new ArrayList<>());
    BoardHandler boardHandler1 = new BoardHandler(keyboard, new LinkedList<>());
    BoardHandler boardHandler2 = new BoardHandler(keyboard, new LinkedList<>());
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);
      
      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);
      
      if (command.equals("/lesson/add")) {
        lessonHandler.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();
      
      } else if (command.equals("/lesson/detail")) {
        lessonHandler.detailLesson();
      
      } else if (command.equals("/lesson/update")) {
        lessonHandler.updateLesson();
      
      } else if (command.equals("/lesson/delete")) {
        lessonHandler.deleteLesson();
      
      } else if (command.equals("/member/add")) {
        memberHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        memberHandler.listMember();
        
      } else if (command.equals("/member/detail")) {
        memberHandler.detailMember();
      
      } else if (command.equals("/member/update")) {
        memberHandler.updateMember();
      
      } else if (command.equals("/member/delete")) {
        memberHandler.deleteMember();
      
      } else if (command.equals("/board/add")) {
        boardHandler1.addBoard();
        
      } else if (command.equals("/board/list")) {
        boardHandler1.listBoard();
        
      } else if (command.equals("/board/detail")) {
        boardHandler1.detailBoard();
      
      } else if (command.equals("/board/update")) {
        boardHandler1.updateBoard();
      
      } else if (command.equals("/board/delete")) {
        boardHandler1.deleteBoard();
      
      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();
        
      } else if (command.equals("/board2/detail")) {
        boardHandler2.detailBoard();
      
      } else if (command.equals("/board2/update")) {
        boardHandler2.updateBoard();
      
      } else if (command.equals("/board2/delete")) {
        boardHandler2.deleteBoard();
      
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<String>() {
        	int index = commandHistory.size() - 1;
        	//     익명클래스        스태틱 멤버
        	
        	@Override
			public boolean hasNext() {
				return index >= 0;
			}

			@Override
			public String next() {
				return commandHistory.get(index--);//현재 인덱스 값을 넣는다 그다음에 인덱스 변수를 따로 증가시킨다.
			}
        	
        });
        
      } else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());
        //printCommandHistory야 commandHistory2.iterator()이 값을 줄테니까 
        // commandHistory2.iterator()에 맞게 
        //printCommandHistory(Iterator<String> iterator)를 실행해
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); 
    }

    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) {//여기에 commandHistory,commandHistory2이거가 들어간다.
	//()에 들어오는거가 Iterator<String> 타입의 commandHistory.iterator()라는 값이 들어온다.
	  try {
		int count = 0;
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			if (++count % 5 == 0) {
				System.out.print(":");
				String input = keyboard.nextLine();
				if (input.equalsIgnoreCase("q"))
					break;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

/*private static void printCommandHistory() {
    Iterator<String> iterator = commandHistory.iterator();//스택:commandHistory
// iterator 이름을 가진 Iterator<String> 타입;
// iterator라는 이름이 commandHistory.iterator()라는 값을 가진다.
//iterator(): ()가 생성자다. 근데 값이 없는 생성자이다.(기본생성자이다.)
 도구: iterator    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
  
  private static void printCommandHistory2() {
    Iterator<String> iterator = commandHistory2.iterator();//어레이디큐:commandHistory2
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }*/

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
