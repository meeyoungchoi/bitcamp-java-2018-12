
package bitcamp.lms;

import java.util.Scanner;

public class App4 {


  public static void main(String[] args) {
    

    Scanner keyboard = new java.util.Scanner(System.in);

    //Lesson인스턴의 주소를 담을 레퍼런스 100개를 생성
      //           메모리주소          레퍼런스 배열(주소를 담는 배)
      Lesson[] lesson= new Lesson[100]; 
      

      int i=0;
    
      while(i < 100) {
 //    클래스이름 변수명           새 객체 생성
      Lesson lesson1 = new Lesson();

      System.out.print("번호를 입력하세요:");
      lesson1.number =Integer.parseInt(keyboard.nextLine());
//     lesson1객체가 가리키는 인스턴스 number 필드에 값을 넣어라
      
      System.out.print("수업명:");
      lesson1.name=keyboard.nextLine();   
     // for(int i=0; i < lesson.length; i++) {
       // lesson[i] = new Lesson();
    ///  }
    
      System.out.print("수업내용:");
      lesson1.content=keyboard.nextLine();
    
    
      System.out.print("시작일? ");
      lesson1.start=keyboard.nextLine();
    
      System.out.print("종료일?");
      lesson1.finish=keyboard.nextLine();

      System.out.print("총수업시간?");
      lesson1.total=keyboard.nextLine();
    

      //System.out.print("일수업시간?");
      //study[i]=keyboard.nextLine(); 
      lesson[i++] = lesson1;//주소가 복사된다.
      //새 인스턴스 주소를 배열에 저장한다.
      //i++;
      
      System.out.println();
      System.out.println("계속 입력하시겠습니까:(y/n)");
      String input=keyboard.nextLine();
      
      if(!input.equalsIgnoreCase("y") && !input.equals("")) {
        break;
              }//if문 끝
      //1. 배열 변수를 만들어야 한다.
      
      //2. 배열로 묶어서 반복시킬 부분을 찾아야 한다.
          }//while문 끝
      
      int j = 0;
      
      //for문으로 변경
      
      while(j < i) {
            System.out.printf("%d, ", lesson[j].number);
            System.out.printf("%s, ", lesson[j].content);
            System.out.printf("%s, ", lesson[j].name);
            System.out.printf("%s ~ %s, ", lesson[j].start, lesson[j].finish);
            
            System.out.printf("%s\n",lesson[j].total);
        
              j++;
              //lesson[j].number=>number라는 인스턴스를 가리키는 레퍼런스 배열
      }
      
  
   
  }
}


      
      //main끝


        
  


  


  


    
        
     
      
 