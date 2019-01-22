//다중 인터페이스 구현 - 한 클래스는 여러 규칙을 준수할 수 있다.
package ch18.c;

//한 클래스가 여러 규칙에 따라 동작하도록 정의할 수 있다.
public class Tool implements ProtocolA, ProtocolB{
  
  //여러 규칙을 모두 만족시키려면
  //여러 규칙의 모든 메서드를 구현해야 한다.
  
  //ProtocolA 규칙에 따라 동작할수 있도록 메서드 구현하기
  @Override
  public void m1() {
    System.out.println("Tool.m1()");
    
  }
  
  @Override
  public void m2() {
    System.out.println("Tool.m2()");
    
  }
  
  //protocoB 규칙에 따라 동작하도록 메서드 구현하기
  //m2는 이미 위에서 프로토콜 a를 구현할 때 만들었기 때문에 또 만들 필요는 없다.
  //같은 시그너처(같은 이름 같은 타입 같은 파라미터)를 갖는 메서드가 여러 규칙에 존재할때, 각 규칙별로 해당 메서드를 구분해서 구현할 방법이 없다!!
  //왜? 호출할때 구분해서 호출할 수 없기 때문이다.
  //그리고 구분하도록 하면 문법이 매우 복잡해진다.
  //그래서 m2()는 프로토콜A와 프로토콜B 규칙에서 공유한다.
  /*@Override
  public void m2() {
    System.out.println("Tool.m2()");
    }*/
  
  //
  @Override
  public void m3() {
    System.out.println("Tool.m3()");
    
  }

}
