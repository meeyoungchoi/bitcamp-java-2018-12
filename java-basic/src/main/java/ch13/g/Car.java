//상속: speciallization:자동차를 더 특별한 기능을 만들낟.(수퍼클래스를 상속 받아서 서브클래스를 만든다.)
package ch13.g;

public class Car {
  String model;
  int cc;
  
  public void run() {
    System.out.println("달린다.");
  }
  
  public void stop() {
    System.out.println("멈춘다.");
  }
  
  

}
