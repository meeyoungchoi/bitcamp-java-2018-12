package ch13;

public class Calculator {

  //이 필드를 갖고 있는 서브 클래스가 접근할 수 있도록 허럭한다.
  protected int result;
  
  //result 필드의 값을 리턴해주는 메서드가 필요하다.
  //result 필드의 값을 제한 했기 때문에 result필드의 값을 리턴해주는 메서드가 필요하다.
  //=>보통 필드의 값을 리턴하는 메서드의 이름을 getxxxxxx라고 짓는다.
  //=>그래서 이런 메서드를 "'getter"라 부른다.
  public int getResult() {//이거 다가 Calculator안에 들어있는 멤버이다.
    return this.result;
  }
  public void plus(int value) {
    this.result += value;//value의 값을 더해줘야 한다.
  }
  
  public void minus(int value) {
    this.result -= value;
  }

}
