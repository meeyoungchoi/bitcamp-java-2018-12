//캡슐화 적용 예 1
package ch12.b;

public class Test01 {

  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(100);
    c.plus(15);
    c.minus(27);
    //result는 캡슐로 보호되기 때문에 직접 접근할 수 없다.
    
   System.out.println(c.getResult());

   
   //클래스를 만든 개발자의 
   Calculator c2 = new Calculator();
   c2.plus(100);
   c2.plus(15);
   
   //임의로 result변수의 값을 변경하려 해도 private으로 접근을 제한했기 때무에
   //값을 변경할 수 없다.
   //=>캡슐로 보호되고 있는 변수이다.
   //c2.result = 100;//결과 값의 왜곡이 불가하다. 이것이 캡슐화 문법이 필요한 이유이다.
   
   c2.minus(27);

   System.out.println(c2.getResult());

  }

}
