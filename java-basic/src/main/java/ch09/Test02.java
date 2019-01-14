//메서드가 사용하는 변수는 그 메서드가 있는 클래스에 두는 것이 좋다.
//그래서 클래스 필드가 등장하게 된다.
package ch09;


public class Test02 {
  
  public static void main(String[] args) {
   
    //계산한기
    //=>2 * 3 - 2 + 7
    Calculator2.plus(2);
    Calculator2.multiple(3);
    Calculator2.minus(2);
    Calculator2.plus(7);
    
  
    
    System.out.println(Calculator2.result);
    
    //Calculator1의 메서드를 이용하여 계산을 수행할 때
    //계산결과를 호출하는 쪽에서 직접 관리하였다.
    // reslut 변수는 Calculator1의 메서드들이 사용하는 변수인데
    //다른 클래스에서 관리하니 너무 불편하다.
    //이런 경우, 
    //변수를 사용하는 클래스에 두는 것이 소스 코드 유지보수에 좋다.
    //
  
   }
}




/**
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
