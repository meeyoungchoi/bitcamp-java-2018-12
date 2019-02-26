//app 01 강사코드 수정
package bitcamp.lms;

import java.util.Scanner;

public class App7 {


  public static void main(String[] args) {
    

    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    Lesson[] lessons = new Lesson[LENGTH];
    
    lesson.number=new int[5];
    lesson.name=new String[5];
    lesson.content=new String[5];
    lesson.start=new String[5];
    lesson.finish=new String[5];
    lesson.total=new String[5];
    lesson.study=new String[5];
    

    int index = 0;
    
      while(index < LENGTH) {
        //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.
      Lesson lesson = new Lesson();

      System.out.print("번호를 입력하세요:");
      lesson.number = Integer.parseInt(keyboard.nextLine());

      //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.
      System.out.print("수업명:");
      lesson.name = keyboard.nextLine();
    
      System.out.print("수업내용:");
      lesson.content = keyboard.nextLine();
    
    
      System.out.print("시작일? ");
      lesson.start = keyboard.nextLine();
    
      System.out.print("종료일?");
      lesson.finish = keyboard.nextLine();

      System.out.print("총수업시간?");
      lesson.total = keyboard.nextLine();
    

      //System.out.print("일수업시간?");
      //study[i]=keyboard.nextLine(); 
      
        lessons[index] = lesson;
      
      index++;
      

      System.out.println("\n계속 입력하시겠습니까:(y/n)");
      String input=keyboard.nextLine();
      System.out.println();
      
      if((!input.equalsIgnoreCase("y"))) {
        break;
              }//if문 끝
     
      System.out.println();
          }
        
        keyboard.close();
      
      //입력된 번호, 과목명, 과목내요, 시작일, 종료일, 총 시간을 한줄에 보여줘야 한다.
      
        for(int j = 0; j < i; j++) {
          System.out.printf("%d, %s, %s, %s ~ %s, %s\n", lesson.number[count], lesson.name[count], 
              lesson.content[count], lesson.start[count], 
              lesson.finish[count], lesson.total[count] );
        }
      
   
      
      }//main끝
   }//class 끝]);
        
  


  


  


    
        
     
      
 