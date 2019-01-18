//상속: generalization 일반화 수행 후
package ch13.i;

//Car 클래스는 Convertible과 DumpTruck에 공통으로 일반 기능을 뽑아서 만든 클래스이다.
//=>이렇게 서브 클래스의 공통 기능을 추출하여 
public class Car {
  String model;
  int cc;
  
  public void run() {
    System.out.println("달린다,");
  }
  
  public void stop() {
    System.out.println("멈춘다.");
  }
  
}
