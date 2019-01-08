//전위연산자 - ++a --a

package ch04;

public class Test08 {

  public static void main(String[] args) {
  

    int a=5;
    int r=++a;
    System.out.printf("%d, %d\n",a,r);
    //r=++a연산 순서
    //1) ++a=>6
    //2) a값을 리턴한다. r=6
    //3) =연산자 수행: r변수에 6값을 넣는다.
    //전위 연산자는 먼저 변수의 값을 --, ++한 후에 그자리에 변수의 값을 넣는다.
    
    a=5;
    r=--a;
    System.out.printf("%d, %d\n",a,r);
    //r=--a
    //1) --a=>a=4
    // 2) a변수의 값을 리턴 r=4
    // 3) =연산 수행 => r변수에 4의 값을 넣는다.
    
    
    a=5;
    r=--a + --a / --a;
    System.out.printf("%d, %d",a,r);
    //
    //1) r=4 + --a / --a
    // 2) 4 + 3 / --a
    //3) 4 + 3 / 2
    //4) 4 + 1
    //r=5
    
    
    
    
  }

}


/***
 
 *
 * 
 * 
 * *
 */



