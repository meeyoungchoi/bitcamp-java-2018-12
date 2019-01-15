//생성자 활용 - java.util.Date 클래스의 생성자


package ch10;

import java.util.Date;

public class Test15 {
  public static void main(String[] args) {//메인메서드 안에서 예외가 발생하면 실행을 멈추가 jvm에게 에러를 떤져준다.

    //Date() 기본 생성자
    Date d1 =new Date(); //현재 시간을 저장한다.
    System.out.println(d1);
  
    //
    Date d2 = new Date(1000);
    System.out.println(d2);
    
    Date d3 = new Date(System.currentTimeMillis());//클래스스 이름으로 바로 호출:스태틱 메소더
    System.out.println(d3);
    
    
    Date d4 = new Date(119, 1, 15);
    System.out.println(d4);
    
    
    //java.sql.date
    java.sql.Date d5 = new java.sql.Date(System.currentTimeMillis());//기본 생성자가 없다.
    System.out.println(d5);//yyyy-mm-dd
    
    //간접적으로 객체를 생성하기
    //valueOf라는 메소드 안에서 new Date한다.
    java.sql.Date d6 =java.sql.Date.valueOf("2019-1-16");
    System.out.println(d6);
   }
}





