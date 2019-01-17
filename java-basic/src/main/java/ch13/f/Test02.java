//상속관계에서 생성자 호출과정2-임의의 생성자 호출하기
package ch13.f;

public class Test02 {

  public static void main(String[] args) {
   Y obj = new Y();
   //생성자 호출과정
   //Y() =>X(int) => object()
   
   obj.m1();
   obj.m2();
   
   //결론
   //수퍼클래스 부터 초기화 작업을 실행한다.
   

  }
}
 