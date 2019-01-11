//메서드 -로컬 변수의 생성과 소멸
package ch06;

public class Test09 {

  public static void main(String[] args) {
   int value = 100;
   m1(value);
   System.out.println(value);//main에서 실행한 value
   
   //  100
   m1(value + 15); //결과:0
   System.out.println(value);
   
   m1(value + 15);
   System.out.println(value);
  }
  
  //가변 파라미터는 무조건 마지막 순서에 와야 한다.
    //static int plus1(int...value, String name) {//컴파일 오류variable argument:변할수 있는      int.. value:가변파라미터
    static void m1(int value ) {//int value: m1이라는 블록 안에서만 사용된다.
      value = 200;//호출하기 전까지는 실행이 안된다.
      
      System.out.printf("m1():%d\n", value);
    }

   

    }
//로컬변수:메서드안에 선언된 변수
//main() - value, String[] args
//m1() - value
//메서드: 메서드 블록안에 선언된 파라미터
    
    
    
    
  




/**
 * 로컬 변수의 생성과 소멸
 * 메서드가 호출될 때 생성된다.
 * 메서드를 모두 실행한 후 리턴 할 때 소멸된다.
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
 * 
 * */
