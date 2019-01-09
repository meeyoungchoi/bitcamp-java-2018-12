//메서드 - 재귀호출
package ch06;

public class Test12 {

  public static void main(String[] args) {
  // int value = 5; //sum(n) = n +sum(n - 1)
    
   int result = sum1(5, sum1(4, sum1(3, sum1(2, sum1(1, 0)))));
   System.out.println(result);
   
   int result2 = 0;
   result2 = sum1(result2, 1);
   result2 = sum1(result2, 2);
   result2 = sum1(result2, 3);
   result2 = sum1(result2, 4);
   result2 = sum1(result2, 5);
   System.out.println(result2);
   
   System.out.println(sum2(10000));
   //위의 알고리즘(결과를 내는 방식)은 다음 수학 공식과 같다.
   //sum(n) = n + sum(n - 1)
    }

  static int sum1 (int a, int b) { //메서드 선언할때는 '=' 안붙인다.
    return a + b;
    
  }
  
  static int sum2 (int n) {
      if (n == 1)
        return n;
      //재귀호출
      //쫄지마라
      //그냥 다른 메소드를 호출했다고 생각해라
      //메소드가 호출되면 스택에 그 메소드가 사용할 변수가 생성된다. 이것만 기억하라
      //재귀호출은 수학 공식을 그대로 표현할 수 있어서 읽기도 쉽고 코딩하기도 쉽다.
      //그러나 계속 메소드를 호출하기 때문에 메모리를 많이 차지하고, 실행 속도가 느리다.
      //특히 메서드 호출이 너무 깊게 들어가면 스택 메모리가 꽉 차서 스택 오버 플로우 예외가 발생한다. 
      //메서드 호출이 깊지 않은 상황에 재귀호출을 적용하라
      return n + sum2(n - 1);
    
      }
}
  

  

    
    
    
    
  




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
