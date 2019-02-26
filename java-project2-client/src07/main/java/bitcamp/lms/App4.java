
package bitcamp.lms;

import java.util.Scanner;

public class App4 {


  public static void main(String[] args) {


    Scanner keyboard = new java.util.Scanner(System.in);

    Lesson[] lesson= new Lesson[100]; 
    Member[] member=new Member[50];
    Board[] board=new Board[50];
    
    int i=0;

    while(i < 100) {
    
    Lesson lesson1 = new Lesson();
      
    System.out.printf("명령을 입력하세요");
    String input=keyboard.nextLine();

    if (input.equals("/lesson add")) {
        System.out.print("번호를 입력하세요:");
        lesson1.number =Integer.parseInt(keyboard.nextLine());


        System.out.print("수업명:");
        lesson1.name =keyboard.nextLine();


        System.out.print("수업내용:");
        lesson1.content=keyboard.nextLine();


        System.out.print("시작일? ");
        lesson1.start=keyboard.nextLine();

        System.out.print("종료일?");
        lesson1.finish=keyboard.nextLine();

        System.out.print("총수업시간?\n");
        lesson1.total=keyboard.nextLine();

        System.out.println("저장하였습니다.");

        System.out.println("");

        lesson[i++] = lesson1;

      } else if (input.equalsIgnoreCase("/lesson/list")) {

        int j = 0;
        while(j < i) {
          System.out.println();
          System.out.printf("번호: %d\n ", lesson[j].number);
          System.out.printf("수업명: %s\n ", lesson[j].name);
          System.out.printf("수업내용: %s\n", lesson[j].content);
          System.out.printf("수업기간: %s ~ %s\n", lesson[j].start, lesson[j].finish);
          System.out.printf("총 수업시간:%s\n",lesson[j].total);
          j++;

         
        }
      
   }//while문 종료
    
 } 
    String input=keyboard.nextLine();
    if (input.equalsIgnoreCase("quit")) {
      
      System.out.printf("안녕!");
      
      
    }   else  {
      
      System.out.println("실행할 수 없는 명령입니다.");
   
          } 
    }
}













