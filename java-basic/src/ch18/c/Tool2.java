//다중 인터페이스를 구현하지 못하는 경우 - 메서드명과 파라미터는 같은 데 리턴 타입이 다른경우
package ch18.c;

//한 클래스가 여러 규칙에 따라 동작하도록 정의할 수 있는데
//불가능한 경우가 있다.
//규칙에 중복되는 메서드 중에 리턴값은 다르고 기타 시크너처는 같은 메서드가 있을 때 불가능하다.
public class Tool2 implements ProtocolA, ProtocolB{
  
  //여러 규칙을 모두 만족시키려면
  //여러 규칙의 모든 메서드를 구현해야 한다.
  
  //다음 메서드는 ProtocolA 규칙은 만족시키지만, 프로토콜c규칙은 만족시키지 못한다.
  @Override
  public void m1() {
    System.out.println("Tool.m1()");
    
  }
  
  @Override
  public void m2() {
    System.out.println("Tool.m2()");
    
  }
  //그럼 리턴 값이 다른 메서드를 만들면 되지 않나요?
  //=>오버로딩 규칙에 따라 파라미터와 메서드명은 같고 리턴값만 다른 메서드를 여러게 만들수 없다.
  @Override 
  public int m2() {
    System.out.println("Tool.m2()");
    return 0;
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
