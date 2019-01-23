//인터페이스 구현 - 규칙에 따라 클래스를 만든다.
package ch18.a;

//규칙에 따라 클래스를 만들면 도구를 사용하는 압장에서 유지보수 하기 좋다.
public class ToolA implements A {
  
  //인터페이스에 따라 클래스를 작성할 때는 인터페이스에 선언된 모든 추상 메서드를 반드시 구현해야 한다.
  //구현하지 않으면 추상클래스를 그대로 갖고 있는 것이 된다.
  @Override
  public void m1() {
   System.out.println("ToolA.m1()");
    
  }

}
