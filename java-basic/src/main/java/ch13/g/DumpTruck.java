//상속:specialization
package ch13.g;
//클래스 이름은 명사형태(동사형은 없다.)
//기존 클래스에 기능을 덧붙여 특별한 클래스를 만드는 것
//=>수퍼 클래스를 상속 받아 서브 클래스를 만드는 것을 specialization 라고 부른다.
//
public class DumpTruck extends Car{
  int weight;
  
  void dump() {
    System.out.println("짐을 내린다.");
  }
  
  

}
