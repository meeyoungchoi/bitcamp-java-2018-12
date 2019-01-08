//전위연산자 - a++ a--

package ch04;

public class Test09 {

  public static void main(String[] args) {
  

   int a=5;
   int r=a++;
   System.out.printf("%d,%d\n",a,r);
   
   // r=a++
   //1) r=5
   //변수의 값을 넣기만 할 뿐 아직 = 연산을 수행하지 않는다
   // =연산은 r-value를 모두 처리한 후에 맨 마지막에 수행된다.
   //2) a++실행
   //a=6;
   //3) = 할당 연산 실행 System.out.println();
   // 따라서 r변수에 5 저장
   // a=6 r=5
   
   a=5;
   r=a++ + a++ * a++;
   System.out.printf("%d,%d\n",a,r);
   //r=5 + a++ * a++
   //r= 5 + 6 * 7
   //a=8=>(a++이므로)
   //r=5+ 42
   //r=47
   //a=8
   
   a=5;
   a=a++;//a=a++ => a=5 a=6으로 증가 근데 마지막으로 a를 할당해야 하므로 5
   System.out.printf("%d",a);
    
    
    
    
  }

}


/***
 
 *
 * 
 * 
 * *
 */



