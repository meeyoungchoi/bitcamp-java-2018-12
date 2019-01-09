//메서드 -로컬 변수와 스택 메모리
package ch06;

public class Test10 {

  public static void main(String[] args) {
   int value = 0;
   m1(++value);//1
   System.out.println(value);
   
  }
  
  //가변 파라미터는 무조건 마지막 순서에 와야 한다.
    //static int plus1(int...value, String name) {//컴파일 오류variable argument:변할수 있는      int.. value:가변파라미터
    static void m1(int value ) {
      m2(++value);
      System.out.println(value);
      
    }

    static void m2(int value ) {
      m3(++value);
      System.out.println(value);
      
    }
    
    static void m3(int value ) {
      System.out.println(++value);
      
     }
  }
//로컬변수:메서드안에 선언된 변수
//main() - value, String[] args
//m1() - value
//메서드: 메서드 블록안에 선언된 파라미터
    
    
    
    
  




/**
 * 
 * 스택 메모리=>'jvm 스택 메모리'
 * 각 스레드 별로 jvm 스택 메모리가 있다.
 * 메서드를 호출할때 프레임이 생성된다.
 * 프레임 안에 로컬 변수, 리턴값, 예외정보(예외가 발생했을때)가 들어있다.
 * 메서드 호출이 끝나면 프레임은 삭제된다.
 * main()은 맨 마지막에 삭제된다.(호출과 실행이 다 끝나야 하므로)
 * 이렇게 메서드가 호출될때 로컬변수가 준비되고 맨 마지막에 호출한 메서드가 먼저 삭제 된다고 해서 스택 메모리 라고 한다.
 * 
 * 스택 방식은 last in first out(후입선출)이다.
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
 * 
 * */
