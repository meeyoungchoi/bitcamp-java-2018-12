//클래스 문법의 또 다른 용도
package ch08;

import java.util.Scanner;

public class Test06 {
  public static void main (String[] args) {
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
      case "+": result = plus(a, b); break;
      case "-": result = minus(a, b); break;
      case "*": result = multiple(a, b); break;
      case "/": result = divide(a, b); break;
      default:
      
        System.out.println("지원하지 않는 연산자 입니다.");
        return;
    }
    
    System.out.printf("%d %s %d = ?\n", a, op, b);
    }
  
  static int plus(int a, int b) {
    return a + b;
  }
 
  static int minus(int a, int b) {
    return a * b;
  }
  
  static int divide(int a, int b) {
    return a / b;
  }
  
  
  static int multiple(int a, int b) {
    return a / b;
  }
}




/**
 *클래스 문법의 용도
 *1). 새 데이터 타입을 정의 할 때
 *2) 관련 메서드를 분류할 때
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
 * 
 * 
 * */
