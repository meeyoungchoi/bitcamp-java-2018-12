package ch13.d;

public class A {
  private int v1 = 100;
  
  public void m1( ) {
    System.out.printf("A.v1 = %d\n",this.v1);//this에는 B 인스턴스의 주소가 들어잇다. B obj = new B(); 200번지로 찾아가서 v1값을 출력해라
  }
  

}
