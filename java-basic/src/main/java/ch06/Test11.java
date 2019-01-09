//메서드 -call by value 와 call by reference
package ch06;

public class Test11 {

  public static void main(String[] args) {
   int value = 100;
   
   //1. call by value:변수에 들어있는 값을 넘긴다.
   //메서드를 호출할 때 파라미터의 값으로
   //기본데어터 타입의 값을 넘겨주는 경우
   //call by value라 부른다.
   //변수의 주소가 넘어가는 것이 아니라 변수의 값이 넘어간다.
   m1(value);
   System.out.println(value);
   
   //2. call by reference
   //메서드를 호출할 때 파라미터 값으로 메모리의 주소를 넘긴다.
   int[] arr=new int[] {100, 200, 300};
   System.out.println(arr[1]);
   m2(arr); //arr의 값을 넘긴다. 어? 그러면 call by value가 아닌가요?
             //그런데 arr의 값은 배열의 주소이다.
             //그래서 주소를 넘겨 주는 것을 call by reference라 부른다.
           //arr:배열의 주소가 담겨서 넘겨진다.
             //주소를 받는쪽에서 그 주소로 찾아가서 값을 바꿀수 있다.
   System.out.println(arr[1]);
      }
  
  //m1()의 value는 값을 받는 변수이다.
  //따라서 main()의 value 변수와 관계가 없다.
    static void m1(int value) {
      value *= 2;
    }
    
    //m1()의 arr는 배열 주소를 받는 변수이다.
    static void m2(int[] arr) {
      arr[1] = 111;
      
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
