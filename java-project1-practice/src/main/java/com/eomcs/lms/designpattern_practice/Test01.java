package com.eomcs.lms.designpattern_practice;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    
    TerminalHandler terminalHandler = new TerminalHandler();
    
    PlusHandler plusHandler = new PlusHandler();
    plusHandler.setNext(terminalHandler);

    MinusHandler minusHandler = new MinusHandler();
    minusHandler.setNext(plusHandler);
    
    MultipleHandler multipleHandler = new MultipleHandler();
    multipleHandler.setNext(minusHandler);
    

    
    while (true) {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("a? ");
      int a = Integer.parseInt(keyboard.nextLine());
      
      System.out.println("b? ");
      int b = Integer.parseInt(keyboard.nextLine());
      
      System.out.println("op? ");
      String op = keyboard.nextLine();
      
      multipleHandler.handle(a, b, op);
    }
  }

}
