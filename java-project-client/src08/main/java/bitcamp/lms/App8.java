package bitcamp.lms;

import java.util.Scanner;
import java.util.Date;

public class App8 {


  public static void main(String[] args) {
   
   
      
      Scanner keyboard = new Scanner(System.in);
      Date today=new Date();
      
      final int LENGTH = 100;
      
      Member[] members = new Member[LENGTH];
          
      int index=0;
      
      while(index < 100) {
          
        Member member=new Member(); 
        
        System.out.printf("번호?");
        member.number = Integer.parseInt(keyboard.nextLine());
        
   
        System.out.printf("이름?");
        member.name = keyboard.nextLine();
        //두번째 while문 종료
        System.out.printf("이메일?");
        member.email = keyboard.nextLine();

        //System.out.printf("암호?");
        //secret[i] =Integer.parseInt(keyboard.nextLine());
    
        System.out.printf("사진?");
        member.photo = keyboard.nextLine();
      
        System.out.printf("전화?");
        member.tel = keyboard.nextLine();
        
        members[index] = member;
        
        index++;
        
        System.out.println();
        System.out.printf("계속 진행하겠습니까:(y/n)");
        String input=keyboard.nextLine();
        
        if ((!input.equalsIgnoreCase("y") && (!input.equalsIgnoreCase("")))) {
            break;
          
        }//if문 종료
        System.out.println();

     }
        keyboard.close();
        
        
        for(int j = 0; j < index; j++) {
          System.out.printf("%d, %s, %s, %s ", members[j].number, members[j].name, members[j].email,
              members[j].photo,members[j].tel );
        }
                 
   
      
  }

}
