//상속의 실제적인 의미
package ch13.c;

public class Test01 {

  public static void main(String[] args) {
    B obj = new B();
    
    //B인스턴스를 이용하여 B가 사용권을 획득한 A클래스의 메서드를 호출할 수 있다.
    obj.m1();
    
    obj.m2();

    //실험
    //bin/main/.../A.clss파일 제거 후 다시 TEst01실행
    //=>결과는 ? A클래스가 없다고 예외가 발생한다.
    //=>의미?
    // 상속받는 다는 것은 수퍼 클래스의 코드를 그대로 ㅂ복제해 온다는 것이 아니다
    //그냥 슈퍼클래스의 코드를 사용할 수 있는 권한을 획득한다는 거이다.
    //그래서 서브 클래스를 사용하려면 반드시 서브 클래스가 상속 받는 
    //모든 조상 클래스가 있어야 한다.
    //
  }

}
