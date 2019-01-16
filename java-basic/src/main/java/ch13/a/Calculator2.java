package ch13.a;
//기존의 클래스에 기능 추가학
//1.
public class Calculator2 {
  //Calculator에 곱하기 나누기 기능을 추가하려면
  //기존의 코드를 그대로 복사 해야 한다.
  private int result;
  

  public int getResult() {//이거 다가 Calculator안에 들어있는 멤버이다.
    return this.result;
  }
  public void plus(int value) {
    this.result += value;//value의 값을 더해줘야 한다.
  }
  
  public void minus(int value) {
    this.result -= value;
  }

  //기능을 추가한다.
  public void multiple(int value) {
    this.result *= value;
    
  }
  
  public void divide(int value) {
    this.result /= value;
  }
}
