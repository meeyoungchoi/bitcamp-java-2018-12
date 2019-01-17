package ch13.f;

//수퍼 클래스를 지정하지 않으면, 무조건 자동으로 java.lang.object를 상속받는다.
//
public class A /*extends Object*/{
  private int v1 = 100;
  
  public A() {
   //생성자를 정의할때 반드시 수퍼 클래스의 어떤 생성자를 호출할 것인지 지정해야 한다.
    //문법: super(파라미터값, 파라미터값,.....); 반드시 지정해야 한다.
    //만약 지정하지 않는다면 무조건 수퍼 클래스의 기본 생성자를 호출한다.
    //  super(); 이렇게 호출한다.
    //수퍼클래스의 생성자를 호출할 때는 반드시 첫 번째 문자응로 와야 한다.
    //
    //System.out.println("A.A()");//수퍼 클래스의 생성자를 호출하는 문장 보다 먼저 올 수 없다.
   // super(); 오류 Constructor call must be the first statement in a constructor
    //super();생략하면 수퍼 클래스의 기본 생성자를 호출하는 코드가 자도응로 추가된다.
    super();//A 클래스의 수퍼클래스는 oBJECT이다. SUPER()는 오브젝트의 기본 생성자를 호출하라는 것이다.
    
    
    System.out.println("A.A()");
  }
  public void m1( ) {
    System.out.printf("A.v1 = %d\n",this.v1);//this에는 B 인스턴스의 주소가 들어잇다. B obj = new B(); 200번지로 찾아가서 v1값을 출력해라
  }
  

}
