// 3단계: 클라이언트와 서버 간에 간단한 문자열 데이터를 주고 받는다.
package com.eomcs.lms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//src3.0
public class ServerApp {

  public static void main(String[] args) {
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {//받을때 in으로 받는가?
      System.out.println("서버 시작!");
      
      while (true) {
        try (Socket socket = serverSocket.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream())) {
          
          System.out.println("클라이언트와 연결되었음.");//이거 다음에 어떤 흐름? 1.
          
          String request = in.nextLine();
          out.println(request);
          out.flush();
          
          
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
