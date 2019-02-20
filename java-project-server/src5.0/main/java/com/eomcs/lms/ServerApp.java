//5단계 - 컬렉션 적용 : 멤버 객체를 담을 컬랙션 준비 src5.0
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
	          
	          
	          loop: while (true) {
	              String request = in.readUTF();
	              System.out.println(request);
	              
	              switch (request) {
	                case "quit":
	                  quit();
	                  break loop;
	                case "add":
	                  add();
	                  break;
	                case "list":
	                  list();
	                  break;
	                default:
	                  out.writeUTF("이 명령을 처리할 수 없음!");
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
	  
	  static void add() throws Exception {
	    members.add((Member)in.readObject());
	    out.writeUTF("OK");
	  }
	  
	  static void list() throws Exception {
	    out.writeObject(members);
	  }

	}














































/*public class ServerApp {
	
	static ArrayList<Member> members = new ArrayList<>();
	static ObjectInputStream in;
	static ObjectOutputStream out;
	
	public static void main(String[] args) {
		
		
		
		try (ServerSocket ss = new ServerSocket(8888)){
			System.out.println("서버 시작!");
			
			while (true) {
				try (Socket socket = ss.accept();
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
					
					System.out.println("클라이언트와 연결되었음");
					members.clear();
					ServerApp.in = in;//크라이ㅇ언트와 통신을 수행할 입출력객체
					ServerApp.out = out;
					
					/*라벨을 붙인다. 중괄로흫를 쓰지않으면 한개의 문장에만 라벨이 붙는다.*/
					/*  loop: while (true) {
							String request = in.readUTF();//객체를 보내는 기능도 갖고있다. 1. 명령어를 읽는다.
							System.out.println(request);
							
							switch (request) {
							case "quit":
								quit();
								break loop;//loop를 왜 붙였나? 
							case "add"://명령어를 받고
								add();
								break;
							case "list":
								list();
								break;
							default:
								out.writeUTF("이 명령을 처리할 수 없음");
								
							}
							out.flush();
					 }
						/*
						Member member = (Member) in.readObject();
						//클라이언트에서 serialize해서 보내온 Member객체의 내용을 출력하라
						System.out.println(member);
						//
						out.writeObject(member);
						out.flush();*/
					
			/*	} catch (Exception e) {
					e.printStackTrace();
					
				}
				System.out.println("클라이언트와의 연결을 끊었음!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void quit() throws Exception {
		
			out.writeUTF("종료함");
			out.flush();
	}
	
	static void add() throws Exception{
		members.add((Member)in.readObject());//객체를 받는다
		out.writeUTF("OK");
	}
	
	static void list() throws Exception {
		out.writeObject(members);//응답결과로 어레이리스트를 보낸다.
	}
}*/
