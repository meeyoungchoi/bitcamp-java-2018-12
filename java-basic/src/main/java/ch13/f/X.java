package ch13.f;


public class X /*extends Object*/{
  private int v1 = 100;
  
  public X(int value) {
  
    //super();
    
    this.v1 = value;
    System.out.println("A.A()");
  }
  
  public void m1( ) {
    System.out.printf("A.v1 = %d\n",this.v1);
  }
  

}
