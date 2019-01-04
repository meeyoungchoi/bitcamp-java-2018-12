//l-value와 r-value 용어r
package ch03;

public class Test04 {

  public static void main(String[] args) {
    
    //자바 기본 타입의 변수immytable(불변)
    
    int a=100;
    int b=a;
    System.out.printf("%d, %d \n",a,b);
    
    a=200;
   
    
    System.out.printf("%d, %d \n",a,b);
    
    //100=20;//컴파일 오류 발생
    //l-value는 반드시 메모리여야 한다.
    //100=a;//컴파일 오류
    
    
    a=300; //r-value는 리터럴 가능하다.
    a=b; //r-value는 변수 가능하다.
    //의미: 변수의 값을 왼쪽 변수에 저장하라는 의미이다.
    
    

  }

}

/**
 * 
 * l-value 와 r-value(=연산자 오른쪽 편을 가리키는 용어)
 * int a;
 * a=100;
 * a:l-value(left value):=연산자 왼쪽 편을 가리키는 용어
 * 100:r-value
 * 
 * 
 * l-value는 반드시 메모리 여야 한다.
 * 100=20=>(컴파일 오류 발생)
 * 
 * 
 * 
 * */








