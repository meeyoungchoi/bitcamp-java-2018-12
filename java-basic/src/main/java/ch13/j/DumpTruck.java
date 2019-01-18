//상속: generalization(일반화)
package ch13.j;

//다음과 같이 필요한 클래스를 정의하여 사용한다.
public class DumpTruck extends Car {

  int weight;
  
  public void dump() {
    System.out.println("짐을 내린다.");
  }
}
