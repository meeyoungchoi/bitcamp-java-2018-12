package ch09;


public class Calculator2 {
  //plus(), minus(), multiple(), divide()가 사용할 변수는 같은 클래스에 둔다.
  //=>클래스 멤버가 사용하는 경우 클래스 멤버로 만들어야 한다.
  static int result = 0; //클래스 필드 (스태틱 필드) 

  static void plus(int a) {
    result += a;
  }
 
  static void minus(int a) {
    result -= a;
  }
  
  static void divide(int a) {
    result /=  a;
  }
  
  
  static void multiple(int a) {
    result *=  a;
  }
  
}
  //클래스를 정의하면서 만든 기능을 간단하게 테스트 할 때
  //다음과 같이 해당 클래스에 main() 메서드를 만들어
  //테스트 해 볼 수 있다.
  //
  
  


/*
 * 클래스 문법의 용도
 * 1. 새 데이터 타입을 정의할 때
 * 2. 관련 메서드를 분류할 때
 * 클래스 문법은 유지보수 하기 쉽도록 관련 기능들을 묶어서 분류할때 사용할수 있다.
 * 
 * 
 */
