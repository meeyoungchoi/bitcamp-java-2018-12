// 배열-일반 변수를 여러 개 사용할 때와 배열을 사용할 때의 차이
package ch03;

public class Test12 {

  public static void main(String[] args) {
    //배열문법을 사용하지 않고 같은 종류의 값을 여러 개의 값을 저장하는 방법
    //=> 저장할 값 개수 만큼 변수를 선언해야 한다.
    int a1, a2, a3, a4, a5;
   
    a1=100;
    a2=90;
    a3=80;
    a4=70;
    a5=60;
    
   
    //변수의 들어 있는 값의 합계를 구해 보자
    int arr1[];//c언어 스타일도 사용할 수 있다.
    int sum1;
    sum1=a1+a2+a3+a4+a5;
    arr1=new int[5];
    arr1[0]=100;
    arr1[1]=90;
    arr1[2]=80;
    arr1[3]=70;
    arr1[4]=60;
    
    //배열 변수에 들어 있는 값의 합계 구하기
    int sum2=0;
    for(int item:arr1) {
      sum2=sum2+item;
    }
    
    //어? 배열 보다 위에 있는 코드가 편한데요?
    //=>만명의 국어 점수를 담을 변수를 선언해 보세요!
    
  
    
    
    
    
   
    
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
 */








