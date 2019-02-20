// 8단계: 서버 실행 테스트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerTest {

  static ObjectOutputStream out;
  static ObjectInputStream in;
  
  public static void main(String[] args) {
    //손님클라이언트 : 
    try (Socket socket = new Socket("localhost", 8888);//얘가 8888을 찾아간다.
/*클라이언트가 서버로 가는거*/        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      
      System.out.println("서버와 연결되었음.");
      ServerTest.in = in;//in을 서버테스트.in에 넣어준다.
      ServerTest.out = out;
      
      new MemberTest(out, in).test();
      System.out.println("----------------------------");
      
      new LessonTest(out, in).test();
      System.out.println("----------------------------");
      
      new BoardTest(out, in).test();
      System.out.println("----------------------------");
      
      quit();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  }
  
  static void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  }
}
