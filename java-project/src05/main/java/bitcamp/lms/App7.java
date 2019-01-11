//app 01 강사코드 수정
package bitcamp.lms;

import java.util.Scanner;

public class App7 {


  public static void main(String[] args) {
    

    Scanner keyboard = new Scanner(System.in);

      
    //1. 배열 변수를 만들어야 한다.
    int[] number=new int[5];
    String[] name=new String[5];
    String[] content=new String[5];
    String[] start=new String[5];
    String[] finish=new String[5];
    String[] total=new String[5];
    String[] study=new String[5];
    
    //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.
    int index=0;
    
      while(index < 5) {
    
      

      System.out.print("번호를 입력하세요:");
      number[index] =Integer.parseInt(keyboard.nextLine());

      
      System.out.print("수업명:");
      name[index]=keyboard.nextLine();
    
      System.out.print("수업내용:");
      content[index]=keyboard.nextLine();
    
    
      System.out.print("시작일? ");
      start[index]=keyboard.nextLine();
    
      System.out.print("종료일?");
      finish[index]=keyboard.nextLine();

      System.out.print("총수업시간?");
      total[index]=keyboard.nextLine();
    

      //System.out.print("일수업시간?");
      //study[i]=keyboard.nextLine(); 
      
      index++;
      

      System.out.println("\n계속 입력하시겠습니까:(y/n)");
      String input=keyboard.nextLine();
      System.out.println();
      
      if((!input.equalsIgnoreCase("y"))) {
        break;
              }//if문 끝
     
     
          }//while문 끝
        //while문 종료후 keyboard.close
        keyboard.close();
      
      //입력된 번호, 과목명, 과목내요, 시작일, 종료일, 총 시간을 한줄에 보여줘야 한다.
      int count=0;
      
      while(count < index) {
        //System.out.printf("%d, ", number[count]);
        //System.out.printf("%s, ", name[count]);
        //System.out.printf("%s, ", content[count]);
        //System.out.printf("%s ~ %s, ", start[count], finish[count]);
        //System.out.printf("%s, \n", total[count]);
        
        System.out.printf("%d, %s, %s, %s ~ %s, %s\n", number[count], name[count], content[count], start[count], finish[count], total[count] );
        
        count++;
            }//두번째 while문 끝
      
      }//main끝
   }//class 끝]);
        
  


  


  


    
        
     
      
 