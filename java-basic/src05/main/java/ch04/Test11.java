//논리연산자: &, | 

package ch04;

public class Test11 {

  public static void main(String[] args) {
  
    //피연산자가 boolean 타입일 때는 &&, ||와 동일하게 수행한다.
    // &&(and) 논리 연산자
    //피 연산자 모두 true 일때만 결과가 true 
    System.out.println(true & true);
    System.out.println(true & false);
 
    // || (or) 
    //둘중 한개 라도 true이면 결과가 true이다.
    System.out.println(true | false);
    System.out.println(false | false);
    
    //피연산자가 정수일 때는 비트 연산을 수행한다.
    //비트연산?
    //비트와 비트끼리 and or연산을 수행한다.
    //1:true 0:false
    //둘다 1일때만 1 
    //하나만 1이면 0
    // &의 피연산자가 정수일때는 비트단위로 연산이 이루어진다.
    int a=0xca; //0000 0000 0000 0000 0000 0000 1100 1010
    int b=0x66; //0000 0000 0000 0000 0000 0000 0110 0110
    System.out.println(a & b);
    //                 0000    0000 0000 0000 0000 0000 0100 0010
    
    System.out.println(a | b);
    //둘중 하나가 1이면 1이다.
    //둘다 1이면 1이다.
    //0000 0000 0000 0000 0000 0000 1110 1110
    //0xee=238
    
    
   
    
    
  }

}


/***
 
 *
 * 
 * 
 * *
 */



