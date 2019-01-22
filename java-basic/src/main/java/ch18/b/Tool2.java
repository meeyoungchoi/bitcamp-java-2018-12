//인터페이스 구현 - 접근 범위를 좁힐 수는 없다.
package ch18.b;

public abstract class Tool2 implements SpecA {
  //public 접근 범위보다 좁
  @Override
  //private void m1() {}
  //protected void m1() {}//
  //void m1() {} 패키지 멤버만 접근할수 있는 default이므로
  public void m1() {}//ok
  
  //모든 추상 메서드를 구현해야 한다. 한개라도 빠드리면 concrete 클래스로 만들수 없다.
  //추상클래스로 만들어야 한다. 왜? 추상 메서드가 있으니까
  //public void m2() {}
}
