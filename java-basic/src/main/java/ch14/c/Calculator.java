//오버로딩(overloading) - 같은 이름의 메서드를 여러 개 정의 할 수 있다.
package ch14.c;

public class Calculator {
  int result;
  
  public void plus(int value) {
    this.result += value; //value의 값을 더해줘야 한다.
  }
  

  
  public void plus(int v1, int v2) {
    this.result += v1 + v2;
  }
  
  public void plus(int[] arr) {
    for (int value : arr) {
      result += value;
    }
  }
  
  public void minus(int v1) {
    this.result -= v1;
  }

}
