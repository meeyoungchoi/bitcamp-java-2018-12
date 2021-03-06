package com.eomcs.lms;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
  static ArrayList<Lesson> lessonList ;
  static ArrayList<Member> memberList;
  static ArrayList<Board> boardList;
  
  public static void main(String[] args) {
    
    loadLessonData();
    loadMemberData();
    loadBoardData();

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
        System.out.println("안녕!");
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
    
    saveLessonData();
    saveMemberData();
    saveBoardData();
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
  
  @SuppressWarnings("unchecked")
private static void loadLessonData() {
    try (ObjectInputStream in = new ObjectInputStream(
    		new BufferedInputStream(
    		new FileInputStream("lesson3.data")))) {//여기에 선언된 변수는 자동으로 close를 해주기 때문에 굳이 close를 또 써줄 필요가 없다.
    	
    	lessonList = (ArrayList<Lesson>) in.readObject();
    
    //	lesssonList = (ArrayList<Lesson>) in.readObject();
    	
   
 
      
    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
      	lessonList = new ArrayList<>();
    } 
  }
  
  private static void saveLessonData() {
    try ( 
        ObjectOutputStream out = new ObjectOutputStream(
        		new BufferedOutputStream(new FileOutputStream("lesson3.data")));) {
      
    	out.writeObject(lessonList);//통째저장
    	
      // 파일 형식: 번호,수업명,설명,시작일,종료일,총수업시간,일수업시간
      /*for (Lesson l : lessonList) {
    	  //
    	  	out.writeInt( l.getNo());
    	  	out.writeUTF(l.getTitle() );
    	  	out.writeUTF(l.getContents());
    	  	out.writeUTF( l.getStartDate().toString() );
    	  	out.writeUTF(l.getEndDate().toString());
    	  	out.writeInt(l.getTotalHours());
    	  	out.writeInt( l.getDayHours());
    	  
            
      }
      */
    } catch (Exception e) {
      System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
  
  private static void loadMemberData() {

    
    try {ObjectInputStream in = new ObjectInputStream(
    		 new BufferedInputStream(
    				 new FileInputStream("member3.data")));
      
     memberList = (ArrayList<Member>) in.readObject();
      
   //int len = in.readInt();
      
      //String line = null; // 형식: 번호,이름,이메일,암호,사진,전화,가입일
      
      /*for (int i = 0; i < len; i++) {
    	  Member member = new Member();
    	  member.setNo(in.readInt());
    	  member.setName(in.readUTF());
    	  member.setEmail(in.readUTF());
    	  member.setPassword(in.readUTF());
    	  member.setPhoto(in.readUTF());
    	  member.setRegisteredDate(Date.valueOf(in.readUTF()));
    	  member.setTel(in.readUTF());
    	  
    	  memberList.add(member);
      }*/
    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
      	lessonList = new ArrayList<>();
    } 
  }
  
  private static void saveMemberData() {
    try (
        ObjectOutputStream out = new ObjectOutputStream(
        		new BufferedOutputStream(
        				new FileOutputStream("lesson.data")));) {//AUTOCLOSABLE
      
      // 파일 형식: 번호,이름,이메일,암호,사진,전화,가입일
    	out.writeObject(memberList);
    	
      /*for (Member m : memberList) {
    	  out.writeInt(m.getNo());
    	  out.writeUTF(m.getName());
    	  out.writeUTF(m.getEmail());
    	  out.writeUTF(m.getPassword());
    	  out.writeUTF(m.getPhoto());
    	  out.writeUTF(m.getTel());
    	  out.writeUTF(m.getRegisteredDate().toString());
    	  
      
      }*/
      
    } catch (Exception e) {
      System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
  
  private static void loadBoardData() {
   try(ObjectInputStream in = new ObjectInputStream(
		   new BufferedInputStream(
				   new FileInputStream("board3.data")))) { 
      
      
      //String line = null; // 형식: 번호,내용,등록일,조회수
      
      //int len = in.readInt();
	   
	   boardList = (ArrayList<Board>) in.readObject();
      
     /*for (int i = 0; i < len; i++) {
    	 Board board = new Board();
    	 board.setNo(in.readInt());
    	 board.setContents(in.readUTF());
    	 board.setCreatedDate(Date.valueOf(in.readUTF()));
    	 
    	 boardList.add(board);
     }*/
    } catch (Exception e) {
      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());
      
    } 
  }
  
  private static void saveBoardData() {
    try (
        ObjectOutputStream out = new ObjectOutputStream(
        		new BufferedOutputStream(
        				new FileOutputStream("board3.data")));) {
      
      // 파일 형식: 번호,내용,등록일,조회수
    	out.writeObject(boardList);
    	
      /*for (Board b : boardList) {
    	  out.writeInt(b.getNo());
    	  out.writeUTF(b.getContents());
    	  out.writeUTF(b.getCreatedDate().toString());
    	  out.writeInt(b.getViewCount());
            
      }
      */
    } catch (Exception e) {
      System.out.println("게시글 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
}
