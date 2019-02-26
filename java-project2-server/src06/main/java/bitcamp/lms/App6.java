
package bitcamp.lms;

import java.util.Scanner;
public class App6 {
   
    public static void main(String[] args) {
      
      Scanner keyboard=new java.util.Scanner(System.in);

      Board[] board=new Board[100];
      int i=0;
      
      while(i < 100) {
          
        Board board1=new Board();
     
        //번호? 1
        System.out.print("번호?");
        board1.number=Integer.parseInt(keyboard.nextLine());
       
        
        //내용? 게시글입니다.
        System.out.print("내용:");
        board1.content=keyboard.nextLine();
        
        //System.out.print("조회수:");
        //board1.look=keyboard.nextLine(); 
        board[i]=board1;
  
       i++;
     
       
       System.out.println();
       System.out.printf("계속진행하겠습니까:(y/n)");
       String input=keyboard.nextLine();
      
       if(!input.equalsIgnoreCase("y") && (!input.equalsIgnoreCase(""))) {
         break;
                 }//if문 종료
      
            }//while문 종료
      
      int j=0;
      
      while(j < i) {
        System.out.printf("%d, ",board[j].number);
        System.out.printf("%s\n ",board[j].content);
        //System.out.printf("%d\n", board[j].look);
        
        j++;
              }//두번째 while문 종료
        }//main 종료
      
    }//class 종료


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
