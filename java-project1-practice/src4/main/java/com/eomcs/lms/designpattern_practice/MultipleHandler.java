package com.eomcs.lms.designpattern_practice;

public class MultipleHandler extends AbstractHandler{
  
  
  @Override
  public void handle(int a, int b, String op) {
    if (op.equals("*")) {
      System.out.printf("%d * %d = %d\n",
          a, b, (a * b));
      return;
    }
    
    next.handle(a, b, op);
    
  }

}
