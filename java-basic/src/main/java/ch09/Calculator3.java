package ch09;


public class Calculator3 {
  
  //클래스에서 공통으로 관리하지 않고
  //개별적으로 관리해야 할 값이 있다면 인스턴스 필드로 선언해라(result)
  int result = 0; //인스턴스 필드 = 논스태틱 필드
 // int ok = 0;
  static void plus (Calculator3 that, int a) {
    //result가 더이상 클래스 필드가 아니기 때문에 다음과 같이 사용할 수 없다.
    //result += a;//컴파일 오류
    
    //파라미터 that에 들어있는 주소로 찾아가서 그 인스턴스의 result 필드를 사용한다.
    //200번지 주소로 찾아가서 그 메모리의  result방에 a를 더한다.
    that.result += a;
    //that.ok += a;
  }
 
  static void minus (Calculator3 that, int a) {
    //result -= a;
    that.result -= a;
  }
  
  static void divide(Calculator3 that, int a) {
    //result /=  a;
    that.result /= a;
  }
  
  
  static void multiple(Calculator3 that, int a) {
    //result *=  a;
    that.result *= a;//that이라는 변수에
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
