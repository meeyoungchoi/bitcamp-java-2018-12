
package bitcamp.lms;

public class App6 {
   
    public static void main(String[] args) {
      
      java.util.Scanner keyboard=new java.util.Scanner(System.in);

   
      int[] number=new int[20];
      String[] content=new String[20];
      int[] look=new int[20];
      
      int i=0;
      
      while(i < 20) {
      
     
        //번호? 1
        System.out.print("번호?");
        number[i]=Integer.parseInt(keyboard.nextLine());
       
        
        //내용? 게시글입니다.
        System.out.print("내용:");
        content[i]=keyboard.nextLine();
        
        //System.out.print("조회수:");
        //look[i]=Integer.parseInt(keyboard.nextLine()); 
        
  
       i++;
       System.out.println();
       System.out.printf("계속진행하겠습니까:(y/n)");
       String input=keyboard.nextLine();
      
       if((!input.equalsIgnoreCase("y") && (!input.equalsIgnoreCase("")))) {
         break;
                 }//if문 종료
      
            }//while문 종료
      
      int j=0;
      
      while(j < i) {
        System.out.printf("%d, ",number[j]);
        System.out.printf("%s, ",content[j]);
        System.out.printf("%d\n", look[j]);
        
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
