//논리연산자: && || ^

package ch04;

public class Test10 {

  public static void main(String[] args) {
  
    // &&(and) 논리 연산자
    //피 연산자 모두 true 일때만 결과가 true 
    System.out.println(true && true);
    System.out.println(true && false);
 
    // || (or) 
    //둘중 한개 라도 true이면 결과가 true이다.
    System.out.println(true || false);
    System.out.println(false || false);
    
    // *(exclusive or)
    //피연산자가 서로 다를 때만 true이다.
    //같으면 false
    System.out.println(true ^ true);  //false
    System.out.println(false ^ false); //false
    System.out.println(true ^ false); //true
    
    //논리연산자의 피연산자 값은 반드시 true 또는 false 여야 한다.
    //System.out.println(1 && 1);//컴파일 오류
    
    //!(not) 논리 연산자
    System.out.println(!true);
    System.out.println(!false);
    
  }

}


/***
 
 *
 * 
 * 
 * *
 */



