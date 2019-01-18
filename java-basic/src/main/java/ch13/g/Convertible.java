//specialization:
package ch13.g;

//기존의 car 클래스를 상속받아 특별한 기능을 덧붙인다.
//specialization이라 한다.
//
public class Convertible extends Car  {
  boolean open;
  
  public void openRoof() {
    open = true;
  }
  
  public void closeRoof() {
    open = false;
  }
  
}
