//8단계 - 컬렉션 적용 : 멤버 객체를 담을 컬랙션 준비
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.eomcs.lms.domain.Member;

public class ServerApp {

	  static ArrayList<Member> members = new ArrayList<>();
	
	  static ObjectInputStream in;
	  static ObjectOutputStream out;
	  
	  public static void main(String[] args) {
	    
	    try (ServerSocket serverSocket = new ServerSocket(8888)) {
	      System.out.println("서버 시작!");
	      
	      while (true) {
	        try (Socket socket = serverSocket.accept();
	            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
	          
	          System.out.println("클라이언트와 연결되었음.");
	          members.clear();
	          ServerApp.in = in;
	          ServerApp.out = out;
	          
	          //MemberService.in = in;
	          //MemberService.out = out;
	          //LessonService.in = in;
	          //LessonService.out = out;
	          //BoardService.in = in;
	          //BoardService.out = out;
	          
	          MemberService memberService = new MemberService(in, out);
	          LessonService lessonService = new LessonService(in, out);
	          BoardService boardService = new BoardService(in, out);
	          
	          
	          loop: while (true) {
	              String request = in.readUTF();
	              System.out.println(request);
	              
	              if (request.startsWith("/member/")) {
	                //MemberService.execute(request);
	            	  memberService.execute(request);
	                
	              } else if (request.startsWith("/lesson/")) {
	                //LessonService.execute(request);
	                lessonService.execute(request);
	                
	              } else if (request.startsWith("/board/")) {
	                //BoardService.execute(request);//이 서비스를 실행하라
	                boardService.execute(request);//이 서비스를 실행하라

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
	    out.writeUTF("종료함!");
	    out.flush();
	  }
	}

