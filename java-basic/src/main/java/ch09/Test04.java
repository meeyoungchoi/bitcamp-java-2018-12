//클래스 필드의 한계
//그래서 클래스 필드가 등장하게 된다.
package ch09;


public class Test04 {
  
  public static void main(String[] args) {
   
    //Calculator1을 사용하여 두 계산식을 동시에 하기

    //식1 2 * 3 - 2 - 7
    //식2 6 / 2 + 8 = ?
    
    //Calculator
    //따라서 다음과 같이 두 개의 계산식을 동시에 수행할 수 없다.
    int result1 = 0;
    int result2 =  0;
    
    result1 = Calculator1.multiple(2,3);//식1께산 2
    result2 = Calculator1.divide(6,2);//식2계싼 6을 생각하겠지만 실제는 2 + 6이 된다
    
    result1 = Calculator1.minus(result1, 2);
    result2 = Calculator1.plus(result2, 8);
    
    result1 = Calculator1.plus(result1, 7);
    
    System.out.println(result1);
    System.out.println(result2);
    
    //Calculator1을 사용할 경우 계산 결과를 직접 관리해야 하기 때문에 불편하다.
    //그러나 여러 계산식을 동시에 처리할 수 있는 이점이 있다.
    
    //Calculator2를 사용할 경우 계산 결과를 직접 관리하지 않아도 되기 때문에 편하다
    //그러나 계산 결과를 클래스에서 한 개만 관리하기 때문에 여러 계싼식을 동시에 실행할 수 없다.
    
   //클래스에서 여러 결과를 따로 따로 관리하는 방법은 없을까?
    //인스턴스 필드를 사용하면 된다.
    
    
  
    
  

    
   
  
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
