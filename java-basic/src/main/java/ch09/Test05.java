//인스턴스 필드의 등장=스태틱 메서드사용
package ch09;


public class Test05 {
  
  public static void main(String[] args) {
   
    //Calculator3을 사용하여 두 계산식을 동시에 하기
    //식1 2 * 3 - 2 - 7
    //식2 6 / 2 + 8 = ?
    
    //Calculator3 설계도에 따라 result 변수를 준비한다.
    Calculator3 c1 = new Calculator3();
    Calculator3 c2 = new Calculator3();
    
    
    //c1에 200번지를 넘긴다.
    Calculator3.plus(c1, 2);
    Calculator3.plus(c2, 6);//(c2에 들어있는 reslut 변수가 있는 인스턴스 주소)인스턴수 주소를 바꿔줬다. 300번지
    
    Calculator3.multiple(c1,3);//식1께산 2
    Calculator3.divide(c2,2);//식2계싼 6을 생각하겠지만 실제는 2 + 6이 된다
    
    Calculator3.minus(c1, 2);
    Calculator3.plus(c2, 9);
    
    Calculator3.plus(c1, 7);
    
    System.out.println(c1.result);
    System.out.println(c2.result);//c2에 저장된 인스턴스 주소로 찾아가서 result값을 출력하라
    
    //오호라~~ result를 인스턴스 필드로 선언하면서 
   //계산 결과를 개별적으로 관리할 수 있게 되었다.
  //그런데 메서드를 호출할 때마다 메서드가 사용할 result를 알려주기 위해
  //파리미터로 인스턴스 주소를 넘겨 줘야 하는 불편함이 생겼다.
  //해결방법?
  //인스턴스 메서드를 사용하라
    
    
    
  
    
  

    
   
  
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
