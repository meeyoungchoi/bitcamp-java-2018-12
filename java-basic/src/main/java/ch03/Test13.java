// 배열-선언과 초기화 시키는 문법
package ch03;

public class Test13 {

  public static void main(String[] args) {
    
    
   
    //레퍼런스 변수를 선언한 후 배열 생성하기
    int[] arr1;
   
    
    arr1=new int[5];
    arr1[0]=100;
    arr1[1]=90;
    arr1[2]=80;
    arr1[3]=70;
    arr1[4]=60;
    
    //레퍼런스 변수를 선언할 때 배열 생성하기
    int[] arr2=new int[5];
    
    //배열 생성과 값을 초기화 시키기
    //=>초기 값을 설정할 때는 배열의 개수를 지정하면 안된다.
    int[] arr3=new int[] {100, 100, 90, 90, 60};
    
    //배열 생성과 동시에 값을 초기화 시킬때 배열 생성 문법을 생략할 수 있다.
    int[] arr4= {100, 90, 80, 70, 60};
    
    //레퍼런스를 변도로 선언한 경우에는 4번 방식처럼 배열 생성 문장을 생략할수 없다.
    int[] arr5;
    //arr5= {90, 90, 90, 90, 90}; //컴파일 오류=>Array constants can only be used in initializers
    arr5=new int[] {90,90,90,90,90}; //ok 생략할 수 없다.
    
    
    
    
  
    
    
    
    
   
    
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








