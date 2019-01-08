// 배열-선언과 초기화 시키는 문법
package ch03;

public class Test13 {

  public static void main(String[] args) {
    
    
   
    //레퍼런스 변수를 선언한 후 배열 생성하기
    int[] arr1;
    //int 타입의 배열을 만들었다 
    //그 배열의 레퍼런스 변수명은 arr1이다.
   
    //arr1이라는 변수 이름을 가지는 int형 배열 5개를 만들었다.
    arr1=new int[5];
    arr1[0]=100; //그 arr1변수의 0번째 인덱스에 100이라는 값을 집어넣었다. , arr1[0]이거를 레퍼런스 변수라고 부른다.
    arr1[1]=90;
    arr1[2]=80;
    arr1[3]=70;
    arr1[4]=60;
    
    //레퍼런스 변수를 선언할 때 배열 생성하기
    int[] arr2=new int[5];
    //int[] sea=new int[10];//sea라는 레퍼런스 변수를 선언하면서 int 타입의 배열을 생성한 것이다.
    
    //배열 생성과 값을 초기화 시키기
    //=>초기 값을 설정할 때는 배열의 개수를 지정하면 안된다.
    int[] arr3=new int[] {100, 100, 90, 90, 60};
    //int[] sea=new int[] {20, 30, 40, 50, 34, 45, 55, 65, 75, 85};
    //sea라는 레퍼런스 변수를 가지는 int 타입의 배열을 생성하고
    //그 배열에 값을 초기화 시킨것이다.
    
    //배열 생성과 동시에 값을 초기화 시킬때 배열 생성 문법을 생략할 수 있다.
    int[] arr4= {100, 90, 80, 70, 60};
    //arr4라는 레퍼런스 변수를 가지는 int타입의 배열을 생성한후 그 값을 초기화시킨것이다.
    
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








