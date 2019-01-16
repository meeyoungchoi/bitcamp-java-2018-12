package ch12.a;

public class Calculator {
  int result;
  
  public void plus(int value) {
    this.result += value;//value의 값을 더해줘야 한다.
  }
  
  public void minus(int value) {
    this.result -= value;
  }

}
