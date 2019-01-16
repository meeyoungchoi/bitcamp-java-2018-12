// wrapper 클래스
package ch11;

import java.util.Date;

public class Test09 {//누구를 상속받는 지를 선언하지 않으면 extends Object가 붙는다.
  public static void main(String[] args) {
   
    //자바는 원시타입(primitive)에 각각에 대응하는 클래스 제공
    //byte - Byte 클래스 등등(java.lang 패키지 소속)
    //이 클래스를 wrapper 클래스라 부른다.
   
    //wrapper 클래스의 생성자가 비난받는다(deprecated)=>사용하지 않는것이 좋다고 결정되었고, 가까운 장래에 제거될 것(제거를 하면 과거버전에서 만든것을 실행할수 없다.)
    //생성자를 사용해서 인스턴스를 생성하지 말라
   // Integer i1 = new Integer(100);

    Integer i1 = Integer.valueOf(100);//메서드를 통해서 만든다.
    //character c = new Character('가');
    Character c1 = Character.valueOf('가');
    
    //wrapper 클래스
    byte b = i1.byteValue(); //int를 byte으로 변환하여 리턴
    String s =i1.toString();//int를 스트링 인스턴스로 턴하는 메서드
    String str = Integer.toHexString(100);//int
    
    
    //wrapper 클래스의 목적
    
    
    printfInt(100);
    printFloat(3.14f);
    printFloat(3.14f);
    
    Integer x = Integer.valueOf(1000);//primitive type의 값을 인스턴스에 담고 담긴 primitive 값을 다시 꺼낸다.
    Float y = Float.valueOf(3.14f);
    String z = "Hello";
    Date today = new Date();//import를 java.util로 해야한다.
    
    printObject(x); //primitive 값을 인스턴스에 담아서 넘길수 있다.(wrapper 클래스의 목적)
    printObject(y);
    printObject(z);
    printObject(today);
    }
  //wrapper 클래스를 사용하지 않으면 각 타입의 값을 처리할 메서드를 여러 개 만들어야 한다.
  static void printfInt(int i) { //printfInt(int i) 여기에 주소가 들어갈수 없다. 파라미터 변수가 값을 요구하는 primitive 타입의 변수이다(인스턴스의 주소를 넘길수 없다.) 
    System.out.println("값 => "+i);
  }
  static void printFloat(float f) {//
    System.out.println("값 => "+ f);
  }
  
  static void printObject(Object obj) {
    System.out.println("값 =>" +obj.toString());
  }
}





