package design_pattern.chain_of_responsibility;

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    
    Scanner keyScan = new Scanner(System.in);
    TerminalHandler terminalHandler = new TerminalHandler();
    PlusHandler plusHandler = new PlusHandler();
    plusHandler.setNext(terminalHandler);
    

    // -연산을 처리하고 싶다면 그 작업을 수행하는 객체를 만들어 체인에 연결하라
    MinusHandler minusHandler = new MinusHandler();
    
    //plusHandler.setNext(minusHandler);
    minusHandler.setNext(plusHandler);
    
    MultipleHandler multipleHandler = new MultipleHandler();
    multipleHandler.setNext(minusHandler);//마이너스 핸들러 앞에 멀티플 핸들러를 붙였다.
    
    //이렇게 기능을 체인으로 엮어 가는 설계 기법을 Chain of Responsibility라 부른다.
    
    while (true) {
      System.out.print("a? ");
      int a = keyScan.nextInt();

      System.out.print("b? ");
      int b = keyScan.nextInt();

      System.out.print("연산자? ");
      String op = keyScan.next();

      //System.out.printf("%d, %d, %s\n",a, b, op);

      multipleHandler.handle(a, b, op);
    }
  }
}
