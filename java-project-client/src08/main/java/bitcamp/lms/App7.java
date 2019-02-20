package bitcamp.lms;

import java.util.Scanner;

public class App7 {
  public static void main(String[] args) {
   
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 100;

    Lesson[] lessons = new Lesson[LENGTH];
    
    int index = 0;
    
      while(index < LENGTH) {
      
        //lesson:클래스의 인스턴스 주소를 저장할 변수
        //lesson에 저장되는 주소는 Lesson 클래스에서 내가 정의해놓은 데이터타입이 저장된다,
       System.out.printf("명령을 입력하세요:");
       String input=keyboard.nextLine();
       
      Lesson lesson = new Lesson();
      //new를 사용해서 Lesson()메모리를 생성한다.(인스턴스)

      System.out.print("번호를 입력하세요:");
      //lesson이라는 인스턴스에 값을 넣었다(레퍼런스.변수)
      lesson.number = Integer.parseInt(keyboard.nextLine());

      System.out.print("수업명:");
      //lesson이라는 인스턴스에 name이라는 변수에 값을 넣었다.
      lesson.name = keyboard.nextLine();
    
      System.out.print("수업내용:");
      //lesson이라는 인스턴스에 content라는 변수에 값을 넣었다.
      lesson.content = keyboard.nextLine();
    
      System.out.print("시작일? ");
      lesson.start = keyboard.nextLine();
    
      System.out.print("종료일?");
      lesson.finish = keyboard.nextLine();

      System.out.print("총수업시간?");
      lesson.total = keyboard.nextLine();
    

      System.out.print("일수업시간?");
      lesson.study = keyboard.nextLine(); 
    
       lessons[index] = lesson;
       //인스턴스가 클래스의 인스턴스의 주소를 저
      
      index++;
      

      System.out.println("\n계속 입력하시겠습니까:(y/n)");
      String input=keyboard.nextLine();
      System.out.println();
      
      if((!input.equalsIgnoreCase("y"))) {
        break;
              }
     
      System.out.println();
          }
        
        keyboard.close();
      

      
        for(int j = 0; j < index; j++) {
          System.out.printf("%d, %s, %s, %s ~ %s, %s\n", lessons[j].number, lessons[j].name, 
              lessons[j].content, lessons[j].start, 
              lessons[j].finish, lessons[j].total, lessons[j].study );
        }
      
   
      
  }

}
