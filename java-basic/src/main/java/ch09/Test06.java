//인스턴스 메서드의 등장
package ch09;


public class Test06 {
  
  public static void main(String[] args) {
   
    //Calculator3을 사용하여 두 계산식을 동시에 하기
    //식1 2 * 3 - 2 - 7
    //식2 6 / 2 + 8 = ?
    
    //Calculator3 설계도에 따라 result 변수를 준비한다.
    Calculator4 c1 = new Calculator4();
    Calculator4 c2 = new Calculator4();
    
    
    //인스턴스 메서드는 인스턴스 주소를 파라미터로 넘겨주는 것이 아니라
    //메서드를 호출하는 코드 앞에 둔다
    //즉 메서드가 사용할 인스턴스 주소를 파라미터가 아닌 메서드 호출앞에 둔다.
    c1.plus( 2);
    c2.plus( 6);//(c2에 들어있는 reslut 변수가 있는 인스턴스 주소)인스턴수 주소를 바꿔줬다. 300번지
    
    c1.multiple(3);//식1께산 2
    c2.divide(2);//식2계싼 6을 생각하겠지만 실제는 2 + 6이 된다
    
    c1.minus( 2);
    c2.plus( 9);
    
    c1.plus( 7);
    
    System.out.println(c1.result);
    System.out.println(c2.result);//c2에 저장된 인스턴스 주소로 찾아가서 result값을 출력하라
    
    //인스턴스 메서드를 사용하면, 인스턴스 주소를 넘기기 쉽다.
    //메서드 호출할 때 앞에 적으면 된다.
    // 예 c1.plus(3);
    //인스턴스 메서드는 인스턴스 주소 없이 호출할 수 없다.
    //Calculator4.plus(3);=>컴파일 오류
    
    Calculator4 c3 = null;
    //c3.plus(3); //런타임 오류(실행할때 뜨는 오류)=>인스턴스 주소 없이 호출하면 NullPointerException예외가 발생
    
    
    
    
  
    
  

    
   
  
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
