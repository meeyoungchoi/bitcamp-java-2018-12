//패키지 용도 - 서로 관련된 일이나 유사한 일을 하는 클래스를 분류 할 때 사용한다.
package ch08;

import java.util.Scanner;

public class Test08 {
  public static void main (String[] args) {
    //calculator 클래스를 향후 유지보수 하기 쉽도록 별도의 패키지로 분류한다.
    //ch08.util 패키지를 만들어 분류한다.
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("계산식?(예: 12 * 2) ");
    int a = keyboard.nextInt();
    
    System.out.println("op?");
    String op = keyboard.next();
    
    System.out.println("b?");
    int b = keyboard.nextInt();
    

    keyboard.close();
    
    int result = 0;
    switch (op) {
      //다른 패키지로 분류한 클래스를 ~~
      //~~
      //클래스를 부르는 또다른 용어:타입
      //메서드를 사용할수 없다 하네요
      //이유? 메서드의 접근 허용이 같은 패키지만 가능하기 때문
      //해당 클래스로 가서 메서드를 공개하라
      case "+": result = ch08.util.Calculator2.plus(a, b); break;
      case "-": result = ch08.util.Calculator2.minus(a, b); break;
      case "*": result = ch08.util.Calculator2.multiple(a, b); break;
      case "/": result = ch08.util.Calculator2.divide(a, b); break;
      
      default:
      
        System.out.println("지원하지 않는 연산자 입니다.");
        return;
    }
    
    System.out.printf("%d %s %d = ?\n", a, op, b);
    }
  

}




/**
 *클래스 문법의 용도
 *1). 새 데이터 타입을 정의 할 때
 *2) 관련 메서드를 분류할 때
 *
 * 
 * 패키지
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
