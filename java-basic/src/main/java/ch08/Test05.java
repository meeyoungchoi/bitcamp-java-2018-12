//클래스 필드 공유
package ch08;

public class Test05 {
  
  static int a; //클래스가 로딩될 때 Method Area에 a라는 이름의 변수를 만들라는 명령어

  public static void main (String[] args) {
    a = 100; // 같은 클래스에 소속된 ~
    m1(); // 같은 클래스에 ~
    m2();
    System.out.println(a);
   }
  
  static void m1() {
    a = 200;
  }
  
  static void m2() {
    a = 300;
  }
  
}




/**
 * 클래스 로딩
 * 1. 클래스를 외부 저장소에서 내부 저장소인 ram으로 로딩한다.
 * 2. 클래스의 바이트코드 유효성을 검사한다.
 * 3. 클래스 내부에서 사용하는 모든 이름(변수명, 메서드명, 클래스명 등) 이름목록을 준비한다.
 * 4. 클래스 필드를 찾아 생성한다.
 * 5. 스태틱 블록이 있으면 순서대로 실행한다.
 *  
 *
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
