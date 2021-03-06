package com.eomcs.lms;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();
  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static ArrayList<Board> boardList = new ArrayList<>();
  static ArrayList<Member> memberList = new ArrayList<>();
  public static void main(String[] args) {
	  
	  //
	  loadLessonData();
	  
	  //
	  loadBoardData();
	  
	  //
	  loadMemberData();
	  

    Map<String,Command> commandMap = new HashMap<>();
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));
    
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);
      
      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);
      
      // 사용자가 입력한 명령으로 Command 객체를 찾는다.
      Command commandHandler = commandMap.get(command);
      
      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        }
      } else if (command.equals("quit")) {
    	  quit();
        break;
        
      } else if (command.equals("history")) {
        printCommandHistory();
        
      } else if (command.equals("history2")) {
        printCommandHistory2();
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); 
    }

    keyboard.close();
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();
    
    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }
  
  @SuppressWarnings("unchecked")
  private static void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();
    
    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
  
  private static void quit() {
	  saveLessonData();
	  saveBoardData();
	  saveMemberData();
	  System.out.println("안녕!");
  }
  


  private static void loadLessonData() {
	  try (FileReader in = new FileReader("lesson.csv");
			  Scanner in2 = new Scanner(in)) {
		  
		  while (true) {
			 // String line = in2.nextLine();//번호, 제목, 내용, 시작일, 종료일, 총강의시간, 일강의시간
			  //String[] values = line.split(",");
			 lessonList.add(Lesson.valueOf(in2.nextLine()));//파일에서 읽어들인것
			  
		  }
	  
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (NoSuchElementException e) {
		System.out.println("수업 데이터 로딩 완료!");
	}
  }
  
  private static void loadBoardData() {
	  try (FileReader in = new FileReader("board.csv");
			  Scanner in3 = new Scanner(in)) {
		  
		  while (true) {
			 // String line = in2.nextLine();//번호, 제목, 내용, 시작일, 종료일, 총강의시간, 일강의시간
			  //String[] values = line.split(",");
			 boardList.add(Board.valueOf(in3.nextLine()));//파일에서 읽어들인것
			  
		  }
	  
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (NoSuchElementException e) {
		System.out.println("게시판 데이터 로딩 완료!");
	}
  }
  
  private static void loadMemberData() {
	  try (FileReader in = new FileReader("member.csv");
			  Scanner in4 = new Scanner(in)) {
		  
		  while (true) {
			 // String line = in2.nextLine();//번호, 제목, 내용, 시작일, 종료일, 총강의시간, 일강의시간
			  //String[] values = line.split(",");
			 memberList.add(Member.valueOf(in4.nextLine()));//파일에서 읽어들인것
			  
		  }
	  
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (NoSuchElementException e) {
		System.out.println("멤버 데이터 로딩 완료!");
	}
  }
  
  private static void saveLessonData() {
	  try (FileWriter out = new FileWriter("lesson.csv");){
		for (Lesson lesson : lessonList) {
			//out.write(lesson.getNo() + "," + lesson.getTitle() + ",");
			out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n", 
					lesson.getNo(),
					lesson.getTitle(),
					lesson.getContents(),
					lesson.getStartDate(),
					lesson.getEndDate(),
					lesson.getTotalHours(),
					lesson.getDayHours()));
		}
	} catch (IOException e) {
		e.printStackTrace();//어디에 버그가 있는가
	}
  }
  
  private static void saveBoardData() {
	  try (FileWriter out2 = new FileWriter("board.csv");){
		for (Board board : boardList) {
			//out.write(lesson.getNo() + "," + lesson.getTitle() + ",");
			out2.write(String.format("%d,%s,%s,%d\n", 
					board.getNo(),
					board.getContents(),
					board.getCreatedDate(),
					board.getViewCount()));
		}
	} catch (IOException e) {
		e.printStackTrace();//어디에 버그가 있는가
	}
  }
  
  private static void saveMemberData() {
	  try (FileWriter out3 = new FileWriter("member.csv");){
		for (Member member : memberList) {
			//out.write(lesson.getNo() + "," + lesson.getTitle() + ",");
			out3.write(String.format("%d,%s,%s,%s,%s,%s,%s\n", 
					member.getNo(),
					member.getName(),
					member.getEmail(),
					member.getPassword(),
					member.getPhoto(),
					member.getTel(),
					member.getRegisteredDate()));
		}
	} catch (IOException e) {
		e.printStackTrace();//어디에 버그가 있는가
	}
  }
}
