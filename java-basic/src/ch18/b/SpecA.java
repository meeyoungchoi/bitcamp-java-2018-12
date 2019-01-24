//인터페잇 정의 - PUBLIC 과 ABSTRACT는 생략할 수 있다.
package ch18.b;

public interface SpecA {
  //규칙이기에 무조건 PUBLIC
  //private abstract void m1();//오류
  //protected abstract void m1();//오류
 //public abstract void m1();//ok
 //abstract void m1();//ok default 접근 제어가 아니다.public을 생략한 것이다.
  void m1();
  void m2();
}
