// 12단계: Service 클래스에서 데이터 처리 코드를 별도의 클래스(DAO)로 분리
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;
  
  static BoardDao boardDao = null; 
  static MemberDao memberDao = null;
  static LessonDao lessonDao = null;

  public static void main(String[] args) {
    
    try {
      boardDao = new BoardDao("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }
    
    try {
      memberDao = new MemberDao("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("회원 데이터 로딩 중 오류 발생!");
    }
    
    try {
      lessonDao = new LessonDao("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("수업 데이터 로딩 중 오류 발생!");
    }
    
    BoardService boardService = new BoardService(boardDao); 
    MemberService memberService = new MemberService(memberDao);
    LessonService lessonService = new LessonService(lessonDao);
    //음식점서버
    try (ServerSocket serverSocket = new ServerSocket(8888)) {//서버가 8888을 열어놓는다.(영업시작)
      System.out.println("서버 시작!");//먼저 열어놓고있는다.
      
      while (true) {
        try (Socket socket = serverSocket.accept();//8888(손님이 들어온다.)
  /*오는 클라이언트를 받는다.*/          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
 /**/           ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          
          boardService.init(in, out);
          memberService.init(in, out);
          lessonService.init(in, out);
          
          System.out.println("클라이언트와 연결되었음.");
          ServerApp.in = in;//서버앱.ㅑin: 위에거 / in: try블럭안에 있는 in.
          ServerApp.out = out;
          
          loop: while (true) {
              String request = in.readUTF();//request:member/add를 받는다.
              System.out.println(request);
              
              if (request.startsWith("/member/")) {
                memberService.execute(request);
                
              } else if (request.startsWith("/lesson/")) {
                lessonService.execute(request);
                
              } else if (request.startsWith("/board/")) {
                boardService.execute(request);
                
              } else if (request.equals("quit")) {
                quit();
                break loop;
                
              } else {
                out.writeUTF("FAIL");
              }
              out.flush();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  static void quit() throws Exception {
    try {
      boardDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }
    
    try {
      memberDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }
    
    try {
      lessonDao.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }
    out.writeUTF("종료함!");
    out.flush();
  }
}







