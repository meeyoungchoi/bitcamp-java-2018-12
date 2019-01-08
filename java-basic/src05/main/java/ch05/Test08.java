//반복문:특정명령어를 계속 반복하고싶을때
//while, do while for(;;) for(:)

package ch05;

public class Test08 {
  

  public static void main(String[] args) {
     
    int a=1;
    
    while (a <= 10) System.out.print(a++ + " ");//출력을 할때는 1이출력된다
    //그후에 a 값이 증가된다.
   System.out.println( );
    
    a=1;
    while (a <= 10)
      System.out.print(a++ + " ");
    
    System.out.println( );
    
    a=1;
    while (a <= 10) { 
      System.out.print(a + " ");
       a++;
    }

  }
  
}

/**
 * while
 * while (조건) 문장1;
 * 
 * while (조건) {
 *  문장1;
 *  문장2;
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * *
 */
       
     
   
   

   
    





