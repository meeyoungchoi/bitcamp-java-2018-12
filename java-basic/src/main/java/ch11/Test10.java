// wrapper 클래스와 오토박싱(auto-boxing)/오토 언박싱(auto unboxing): 인스턴스에 담긴 primitive 값을 다시 꺼내는 작업
package ch11;

import java.util.Date;

public class Test10 {//누구를 상속받는 지를 선언하지 않으면 extends Object가 붙는다.
  public static void main(String[] args) {
   //primative type의 값을 인스턴스에 담고
    //인스턴스에 담긴 primitive 값을 다시 꺼내는 작업싱 불편하다.
    Integer obj1 = Integer.valueOf(1000);//boxing
    
    int i1 = obj1.intValue();//unboxing
    
    //그래서 자바는 박싱과 언박식을 코드 문맥에 따라 자동으로 수행한다.
    int i2 = obj1;//오토박싱 내부저그올 obj1.intValue()을 호출한다. obj1객체에 들어있는 주소를 i2에 담는다.
    Integer obj2 = 200;//오토박싱 내부적으로 INteger.valueOF(200)을 호출
  }
}





