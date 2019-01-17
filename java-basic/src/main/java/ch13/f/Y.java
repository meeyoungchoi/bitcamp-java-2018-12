package ch13.f;

public class Y extends X{
  private int v2 = 200;
  

  
  public Y() {//생성자
    //super(); //Implicit super constructor X() is undefined. Must explicitly invoke another constructor
    //B의 수퍼 클래스? X 클래스이다. X 클래스는 기본 생성자가 없다.
    super(500);//이런경우 개발자가 호출할 수퍼 클래스의 생성자를 명시해야 한다.(수퍼클래스의 유효한 생성자를 넣어줘야 한다.)
    System.out.println("B.B()");
  }
  
  public void m2( ) {
    System.out.printf("B.v2 = %d",this.v2);

  }
  

}
