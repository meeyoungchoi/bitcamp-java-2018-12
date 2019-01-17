package ch13.f;

public class B extends A{
  private int v2 = 200;
  

  
  public B() {//생성자
    super(); //b의 수퍼 클래스 A클래스이다. 즉, A 클래스의 기본 생성자를 호출한다.
    System.out.println("B.B()");
  }
  
  public void m2( ) {
    System.out.printf("B.v2 = %d",this.v2);

  }
  

}
