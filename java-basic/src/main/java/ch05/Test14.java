
//do while 반복문

package ch05;

public class Test14 {
  

  public static void main(String[] args) {
    //변수초기화 시키는 문장에 여러 개의 변수를 선언 할 수 있다.
    //변수 증가문에 여러 개의 문장을 작성할 수 있다.
      for (int i = 1 , j = 1 , k = 1; i <= 10; i++ )
        System.out.printf( "(%d,%d,%d) ", i, j, k);
      System.out.println();
      
      //for 문의 충접
      for (int i =1; i < 10; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print(j + " ");
        }
        System.out.println();
      }
      System.out.println("======================================");
      
     
    
      for (int i = 1 , j = 1 , k = 1; i <= 10; i++)
        System.out.printf( "(%d,%d,%d) ", i, j, k);
      System.out.println();
      
     
      //break 라벨명;
      loop1: 
      for (int i =1; i < 10; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print(j + " ");
          if (j == 5)
            break loop1;//break가  라벨로 지정한 문장을 나간다.
        }
        System.out.println();
      }
      System.out.println("======================================");
    
  
      for (int i =1; i < 10; i++) {
        for (int j = 1; j <= i; j++) {
          
      if (j % 2 == 0)
        continue;//break가  라벨로 지정한 문장을 나간다.
      System.out.print(j + " ");
    }
    System.out.println();
  }
  System.out.println("======================================");
  }
}

/*
 *for 반복문
 *배열과 함께 사용할때 유용하다.
 *
 *for(변수초기화; 조건; 변수증가문)
 * 문장1;
 * 
 * for(변수초기화; 조건; 변수증가문)
 * 문장1;
 * 
 * for(변)
 * 
 * 
 * 
 * 
 * *
 */
       
     
   
   

   
    





