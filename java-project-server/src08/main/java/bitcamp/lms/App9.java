package bitcamp.lms;

import java.util.Scanner;
import java.util.Date;
public class App9 {

    
    
    public static void main(String[] args) {
      
      Scanner keyboard = new java.util.Scanner(System.in);

      final int LENGTH = 100;
      Board[] board = new Board[LENGTH];
      
      int index = 0;
      
      while(index < LENGTH) {
          
        Board boards = new Board();
     
       
        System.out.print("번호?");
        boards.number = Integer.parseInt(keyboard.nextLine());
       
        
        //내용? 게시글입니다.
        System.out.print("내용:");
        boards.content = keyboard.nextLine();
        
        //System.out.print("조회수:");
        //board1.look=keyboard.nextLine(); 
        board[index] = boards;
  
        index++;
     
       
       System.out.println();
       System.out.printf("계속진행하겠습니까:(y/n)");
       String input = keyboard.nextLine();
      
       if(!input.equalsIgnoreCase("y") && (!input.equalsIgnoreCase(""))) {
         break;
                 }//if문 종료
      
       //keyboard.close();
       
            }
       
       for (int j = 0; j < index; j++) {
         System.out.printf("%d,%s\n ",board[j].number, board[j].content);
         
         
                 }
  
     }//main 종료 
}
