
package bitcamp.lms;

public class App3 {
   
    public static void main(String[] args) {
      
      java.util.Scanner keyboard=new java.util.Scanner(System.in);
      java.util.Date today = new java.util.Date();
   
      
      int[] number=new int[50];
      String[] content=new String[50];
      
      int i=0;
      
      while(i < 50) {
        //번호? 1
        System.out.print("번호?");
        number[i]=Integer.parseInt(keyboard.nextLine());
       
        
        //내용? 게시글입니다.
        System.out.print("내용:");
        content[i]=keyboard.nextLine();
        
       i++;
       
       System.out.println();
       System.out.print("계속입력하시겠습니까(y/n)");
       String input=keyboard.nextLine();

       
       if (!input.equalsIgnoreCase("y") && !input.equals("")) {
           break;
       }
  }
      keyboard.close();
      
      int j=0;
      
      while(j < i) {
        System.out.printf("%d, ",number[j]);
        System.out.printf("%s, ",content[j]);
        System.out.printf("%1$tY-%1$tm-%1$td, ", today);
        System.out.printf("조회수: 0\n");
        
        j++;
        
        
        
        
        }
      
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
