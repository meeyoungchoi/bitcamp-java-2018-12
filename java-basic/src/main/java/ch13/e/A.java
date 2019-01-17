package ch13.e;

public class A {
  private int v1 = 100;
  
  {//인스턴스 블록
    v1 = 110;
    System.out.println("A.{}");
  }
  
  public A() {//
    v1 = 120;
    System.out.println("A.A()");
  }
  public void m1( ) {
    System.out.printf("A.v1 = %d\n",this.v1);//this에는 B 인스턴스의 주소가 들어잇다. B obj = new B(); 200번지로 찾아가서 v1값을 출력해라
  }
  

}
