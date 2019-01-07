
package bitcamp.lms;

public class App3 {
   
    public static void main(String[] args) {
      
      java.util.Scanner keyboard=new java.util.Scanner(System.in);
   
      //번호? 1
      System.out.printf("번호?");
      int number=keyboard.nextInt();
      keyboard.nextLine();
      
      //내용? 게시글입니다.
      System.out.printf("내용:");
      String content=keyboard.nextLine();
      
      //번호: 1
      System.out.printf("번호:");
      int number1=keyboard.nextInt();
      keyboard.nextLine();
      
      
      //내용: 게시글입니다.
      System.out.printf("내용:");
      String content1=keyboard.nextLine();
      
      //작성일: 2019-01-01
      System.out.printf("작성일:");
      String write=keyboard.nextLine();
      
      //조회수: 0
      System.out.printf("조회수:");
      int number2=keyboard.nextInt();
      keyboard.nextLine();
      
      
      
    }
}

/*
 * ### 작업3) 한 개의 게시글을 입력 받아 출력하라.

App3.java 실행 결과

```
번호? 1
내용? 게시글입니다.

번호: 1
내용: 게시글입니다.
작성일: 2019-01-01
조회수: 0
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
